import java.nio.file.FileSystems;

public class Thread1 extends Thread {
	String filePath;
	FilePlayer filePlayer;

	public Thread1() {
		filePath = FileSystems.getDefault().getPath(new String()).toAbsolutePath() + "/src/Sounds/";
		filePlayer = new FilePlayer();
	}

	public void delay(int ms) {
		try {
			Thread1.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void file_play(String filename) {
		filePlayer.play(filePath + filename + ".wav");
		System.out.println(filename);
	}

	@Override
	public void run() {

		delay(600);

		file_play("re");
		delay(1200);

		file_play("fa");
		delay(1200);

		file_play("la");
		delay(1200);

		delay(100);
		file_play("do-octave");
		delay(600);

		// Twinkle Twinkle Little Star

		file_play("do");
		delay(600);
		file_play("do");
		delay(600);

		file_play("sol");
		delay(600);
		file_play("sol");
		delay(1800);

		file_play("sol");
		delay(2400);

		file_play("mi");
		delay(600);
		file_play("mi");
		delay(1800);

		file_play("do");
		delay(1200);

		file_play("sol");
		delay(600);
		file_play("sol");
		delay(1800);

		file_play("mi");
		delay(600);
		file_play("mi");
		delay(1800);

		file_play("sol");
		delay(600);
		file_play("sol");
		delay(1800);

		file_play("mi");
		delay(600);
		file_play("mi");
		delay(1800);

		file_play("do");
		delay(600);
		file_play("do");
		delay(600);

		file_play("sol");
		delay(600);
		file_play("sol");
		delay(1800);

		file_play("sol");
		delay(2400);

		file_play("mi");
		delay(600);
		file_play("mi");
		delay(1800);

		file_play("do");
		delay(1200);

	}

}
