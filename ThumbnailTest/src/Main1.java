import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;

public class Main1 {

	public static void main(String[] args) throws IOException {
		//Thumbnails.of(new File("C:\\temp\\Hydrangeas.jpg")).size(150, 150).toFile(new File("c:\\temp\\1.jpg"));
		
		BufferedImage waterImg = ImageIO.read(new File("C:\\temp\\rupenglog.png"));//º”‘ÿÀÆ”°Õº∆¨
		Thumbnails.of(new File("C:\\temp\\Hydrangeas.jpg")).size(500, 500).watermark(Positions.BOTTOM_RIGHT, waterImg, 0.8f)
			.toFile("c:\\temp\\hhhh.jpg");
	}

}
