package com.mobile.belajar_mvp_mp3.presnter;

public class MainPresentImpl implements Mainpresenter {

    MainView mainView;

    public MainPresentImpl(MainView mainView){
        this.mainView=mainView;
    }

    @Override
    public void luas(Double alas, Double tinggi) {
        Double luas = alas*tinggi;
        mainView.hasilluas(luas);

    }

    @Override
    public void keliling(Double panjang, Double lebar) {
        Double keliling = 2*(panjang+lebar);
        mainView.hasilkel(keliling);
    }
}
