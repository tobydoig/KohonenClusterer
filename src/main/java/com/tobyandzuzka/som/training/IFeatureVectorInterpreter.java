package com.tobyandzuzka.som.training;

import java.awt.Color;

import com.tobyandzuzka.som.FeatureVector;

public interface IFeatureVectorInterpreter {

  public abstract Color toColor(FeatureVector fv);

  public abstract String getDescription(FeatureVector fv);

}
