package TP8.P2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Observatorio {
    private Lock lock = new ReentrantLock();
    private Condition visitantes = lock.newCondition();
    private Condition mantenimiento = lock.newCondition();
    private Condition investigadores = lock.newCondition();
    private int capacidad, genteEnSala = 0, visitantesEnSilla = 0;
    private int visistantesEsperando, mantenimientoEsperando = 0, investigadoresEsperando = 0;
    private boolean banderaVisitante = true;
    private boolean banderaMantenimiento = true;
    private boolean banderaInvestigador = true;

    public Observatorio(int capacidad) {
        this.capacidad = capacidad;
    }

    public void visitar(boolean silla) {
        try {
            lock.lock();
            System.out.println("El Visitante: " + Thread.currentThread().getName() + " quiere entrar al observatorio");
            visistantesEsperando++;
            while (!banderaVisitante || genteEnSala > capacidad) {
                visitantes.await();
            }
            while (silla && capacidad >= 30) {
                visitantes.await();
            }
            visistantesEsperando--;
            if (genteEnSala == 0) {
                banderaInvestigador = false;
                banderaMantenimiento = false;
            }
            genteEnSala++;
            if (silla) {
                visitantesEnSilla++;
                if (capacidad == 50) {
                    capacidad = 30;
                }
                System.out.println(
                        "El Visitante: " + Thread.currentThread().getName() + " entro al observatorio(tiene silla)");
            } else {
                System.out.println("El Visitante: " + Thread.currentThread().getName() + " entro al observatorio");
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void salirVisita(boolean silla) {
        try {
            lock.lock();
            genteEnSala--;
            if (silla) {
                visitantesEnSilla--;
                if (visitantesEnSilla == 0) {
                    capacidad = 50;
                }
                System.out.println(
                        "El Visitante: " + Thread.currentThread().getName() + " salio del observatorio(tiene silla)");
            } else {
                System.out.println("El Visitante: " + Thread.currentThread().getName() + " salio del observatorio");
            }
            if (genteEnSala == 0) {
                banderaVisitante = false;
                if (mantenimientoEsperando > 0) {
                    banderaMantenimiento = true;
                    mantenimiento.signalAll();
                } else {
                    if (investigadoresEsperando > 0) {
                        banderaInvestigador = true;
                        investigadores.signalAll();
                    }
                }
            }
        } catch (

        Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void entraMantenimiento() {
        try {
            lock.lock();
            while (!banderaMantenimiento) {
                mantenimiento.await();
            }
            if (genteEnSala == 0) {
                banderaInvestigador = false;
                banderaVisitante = false;
            }
            genteEnSala++;
            System.out.println("Entro un personal de mantenimiento: " + Thread.currentThread().getName());

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void saleMantenimiento() {
        try {
            lock.lock();
            genteEnSala--;
            System.out.println("Salio un personal de mantenimiento: " + Thread.currentThread().getName());
            if (genteEnSala == 0) {
                banderaMantenimiento = false;
                if (investigadoresEsperando > 0) {
                    banderaInvestigador = true;
                    investigadores.signalAll();
                } else {
                    if (visistantesEsperando > 0) {
                        banderaVisitante = true;
                        visitantes.signalAll();
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void entraInvestigador() {
        try {
            lock.lock();
            while (!banderaInvestigador || genteEnSala > 0) {
                investigadores.await();
            }
            if (genteEnSala == 0) {
                banderaMantenimiento = false;
                banderaVisitante = false;
            }
            genteEnSala++;
            System.out.println("ATENCION: ¡¡¡¡ENTRO UN INVESTIGADOR!!!! " + Thread.currentThread().getName());
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void saleInvestigador() {
        try {
            lock.lock();
            genteEnSala--;
            System.out.println("ACABA DE SALIR EL INVESTIGADOR: " + Thread.currentThread().getName());

            if (genteEnSala == 0) {
                banderaInvestigador = false;
                if (visistantesEsperando > 0) {
                    banderaVisitante = true;
                    visitantes.signalAll();
                } else {
                    if (mantenimientoEsperando > 0) {
                        banderaMantenimiento = true;
                        mantenimiento.signalAll();
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }
}
