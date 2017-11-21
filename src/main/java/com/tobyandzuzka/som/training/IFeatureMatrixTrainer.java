package com.tobyandzuzka.som.training;

import com.tobyandzuzka.som.FeatureMatrix;

public interface IFeatureMatrixTrainer {
  public void train(FeatureMatrix matrix, ITrainingSetProvider trainingSet, ITrainingObserver observer);
}
