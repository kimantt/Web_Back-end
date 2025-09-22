package game;

import java.util.Random;

public abstract class Game<T> {
	// 게임 공통 필요요소를 가진 추상 클래스

	Random random = new Random();

	public abstract T run();
	
}
