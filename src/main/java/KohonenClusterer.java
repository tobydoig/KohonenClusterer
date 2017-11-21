import java.io.File;
import java.io.IOException;

import javax.swing.SwingUtilities;

import com.tobyandzuzka.som.FeatureMatrix;
import com.tobyandzuzka.som.training.DocumentTrainingSet;
import com.tobyandzuzka.som.training.IFeatureMatrixTrainer;
import com.tobyandzuzka.som.training.ITrainingSetProvider;
import com.tobyandzuzka.som.training.KohonenTrainer;
import com.tobyandzuzka.som.training.PrimaryColorTrainingSet;
import com.tobyandzuzka.som.ui.MainFrame;

//  http://www.ai-junkie.com/ann/som/som1.html

public class KohonenClusterer {
  private static final int NUM_TRAINING_ITERATIONS = 500;
  private static final int OUTPUT_WIDTH = 40;
  private static final int OUTPUT_HEIGHT = OUTPUT_WIDTH;
  
  private static ITrainingSetProvider createPrimaryColor() {
    return new PrimaryColorTrainingSet();
  }
  
  private static ITrainingSetProvider createDocumentsStatic() {
    DocumentTrainingSet trainingSet = new DocumentTrainingSet();
    trainingSet.addDocument("mary and lucy went for a walk in the park");
    trainingSet.addDocument("lucy and mary are sisters");
    trainingSet.addDocument("jack likes to run in the park");
    trainingSet.addDocument("mike and jack are brothers");
    trainingSet.addDocument("jack saw mary in the park");
    
    return trainingSet;
  }
  
  private static ITrainingSetProvider createDocumentsFromFiles() throws IOException {
    DocumentTrainingSet trainingSet = new DocumentTrainingSet();
    trainingSet.addDocuments(new File("articles"));
    
    return trainingSet;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          ITrainingSetProvider trainingSet;
          
          if (true) trainingSet = createPrimaryColor();
          if (false) trainingSet = createDocumentsStatic();
          if (false) trainingSet = createDocumentsFromFiles();
          
          System.out.println("Using " + trainingSet.getClass().getSimpleName());
          
          IFeatureMatrixTrainer trainer = new KohonenTrainer(NUM_TRAINING_ITERATIONS);
          FeatureMatrix matrix = new FeatureMatrix(OUTPUT_WIDTH, OUTPUT_HEIGHT, trainingSet.getNumFeatures());
          new MainFrame(matrix, trainingSet, trainer);
          
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
   });
  }
}
