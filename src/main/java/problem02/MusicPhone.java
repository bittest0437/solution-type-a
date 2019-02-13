package problem02;

public class MusicPhone extends Phone {
	
	@Override
	public void execute( String function ) {
		if (function.equals("음악")) {
			System.out.println(playMusic());
			return;
		}
		
		super.execute(function);
	}

	public String playMusic() {
		return "MP3재생";
	}
}