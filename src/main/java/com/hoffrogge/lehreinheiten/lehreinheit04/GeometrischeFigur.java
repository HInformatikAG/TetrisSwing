package com.hoffrogge.lehreinheiten.lehreinheit04;

import com.hoffrogge.tetris.model.Punkt;

import java.awt.*;

public interface GeometrischeFigur {

    void setMittelpunkt(Punkt mittelpunkt);

    Punkt getMittelPunkt();

    void setDurchmesser(int d);

    Color getLinienFarbe();

    void setLinienFarbe(Color farbe);

    void zeichnen(Graphics graphics);
}