package Wątki.ProblemKonsumentaIProducenta;

interface Magazyn <T>{

    public void addItem(T product) throws InterruptedException;
    public T get() throws  InterruptedException;
}

