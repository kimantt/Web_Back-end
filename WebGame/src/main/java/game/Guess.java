package game;

public class Guess extends Game<Guess.GuessResultPack> {
	// 숫자 맞추기 게임
	
	private int computerNo;
	private int playerNo;
	
	public Guess() {
		this.computerNo = random.nextInt(10) + 1;
		System.out.println(computerNo);
	}
	
	public GuessResultPack run(String playerNo) {
		try {
			this.playerNo = Integer.parseInt(playerNo);
			if (this.playerNo < 1 || this.playerNo > 10) {
				return new GuessResultPack(false, "오류 발생 : 지정된 범위의 숫자만 입력해주세요.");
			}
			
			return this.run();
			
		} catch(Exception e) {
			return new GuessResultPack(false, "오류 발생 : 지정된 범위의 숫자만 입력해주세요.");
		}
	}

	@Override
	public GuessResultPack run() {
		if (playerNo != computerNo) {
			return new GuessResultPack(false, "아닙니다. 다시 맞춰보세요^^");
		}
		return new GuessResultPack(true, "맞췄습니다~ 나의 숫자는 " + computerNo + "입니다");
	}
	
	public class GuessResultPack {
		public boolean correct;
		public final String result;

		public GuessResultPack(boolean correct, String result) {
			this.correct = correct;
			this.result = result;
		}
	}
}
