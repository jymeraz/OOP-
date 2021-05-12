import java.nio.file.FileSystems;

public class Thread2 extends Thread {
	String filePath;
	FilePlayer filePlayer;

	public Thread2() {
		filePath = FileSystems.getDefault().getPath(new String()).toAbsolutePath() + "/src/Sounds/";
		filePlayer = new FilePlayer();
	}

	public void delay(int sec) {
		try {
			Thread1.sleep(sec);
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

		file_play("do");
		delay(1200);

		file_play("mi");
		delay(1200);

		file_play("sol");
		delay(1200);

		file_play("si");
		delay(604);

		file_play("do-octave");
		delay(600);

		// Twinkle Twinkle Little Star

		delay(2500);

		file_play("la");
		delay(600);
		file_play("la");
		delay(1800);

		file_play("fa");
		delay(600);
		file_play("fa");
		delay(1800);

		file_play("re");
		delay(600);
		file_play("re");
		delay(3000);

		file_play("fa");
		delay(600);
		file_play("fa");
		delay(1800);

		file_play("re");
		delay(2400);

		file_play("fa");
		delay(600);
		file_play("fa");
		delay(1800);

		file_play("re");
		delay(1200);

		delay(2500);

		file_play("la");
		delay(600);
		file_play("la");
		delay(1800);

		file_play("fa");
		delay(600);
		file_play("fa");
		delay(1800);

		file_play("re");
		delay(600);
		file_play("re");
		delay(3000);
	}
}
