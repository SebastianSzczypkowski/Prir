package UslugiSieciowe.src.Uslugisiecowecz1;

import Uslugisiecowecz1.Kalkulator;

public class KalkulatorImpl implements Kalkulator {
    @Override
    public double dodaj(double a, double b) {
        return a+b;
    }

    @Override
    public double odejmij(double a, double b) {
        return a-b;
    }

    @Override
    public double mnoz(double a, double b) {
        return a*b;
    }

    @Override
    public double dziel(double a, double b) {
        return a/b;
    }
}
