package app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import model.MorphableModel;
import model.MorphableModelLoader;

import render.FittingStrategy;
import util.Log;
import util.Log.LogType;

public class FittingApp {

	public static void main(String[] args) {
		Logger.getLogger("").setLevel(Level.WARNING);
		Log.disableType(LogType.TIME);
		//Log.disableLevel(LogLevel.INFO);

		try {
//			MorphableModel mm = MorphableModelBuilder.LoadDirectory("data", FileType.PLY);
			MorphableModel mm = MorphableModelLoader.loadMAT(10);
			BufferedImage target = ImageIO.read(new File("audrey.png"));
			
			FittingStrategy fs = new FittingStrategy(mm, target);
			fs.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
