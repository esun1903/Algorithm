import java.util.*;

public class Main_16236_ds {

	private static int[] DX = { 1, -1, 0, 0 };
	private static int[] DY = { 0, 0, 1, -1 };
	
	private static int n;
	private static int[][] arr;
	private static int[][] dir;
	
	private static List<Fish> fishList = new ArrayList<>();
	private static Shark shark;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		arr = new int[n][n];
		dir = new int[n][n];
		
		
		for (int i = 0; i < n; i++) {
			String[] temp = new String[n];
			temp = sc.nextLine().split(" ");
			for(int j = 0; j < n; j++) {
				int now = Integer.parseInt(temp[j]);
				arr[i][j] = now;
				if	(now > 0) {
					if	(now != 9) {
						fishList.add(new Fish(i, j, now));
					}else {
						shark = new Shark(i, j);
						dir[i][j] = 1;
					}
				}
			}
		}
		
		int result = func();
		System.out.println(result);
	}
	
	private static int func() {
		int sec = 0;
		
		while(true) {
			//System.out.println(sec  + "초");
			//System.out.println(shark.toString());
			int flag = func2();
			
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
			
 			if	(flag == 0) {
				break;
			}else {
				sec+= flag;
			}
		}
		
		return sec;
	}
	
	private static int func2() {
		int sec = 0;

		Fish lastFish = null;
		int lastDistance = Integer.MAX_VALUE;
		
		for(Fish fish : fishList) {
			int temp = bfs(fish);
			if	(temp != Integer.MAX_VALUE) {
				temp--;
				if(fish.size < shark.size) {
				
					if (temp <= lastDistance) {
						if (lastFish == null) {
							lastFish = fish;
							lastDistance = temp;
						} else {
							if (temp < lastDistance) {
								lastFish = fish;
								lastDistance = temp;
							} else {
								if (fish.x < lastFish.x) {
									lastFish = fish;
									lastDistance = temp;
								} else if (fish.x == lastFish.x) {
									if (fish.y < lastFish.y) {
										lastFish = fish;
										lastDistance = temp;
									}
								}
							}
						}
					}
					
				}
			}
		}
		
		if	(lastFish != null) {
			//System.out.println(lastFish.toString() + " " + lastDistance +"초 예정");
			shark.count++;
			if(shark.count == shark.size) {
				shark.size++;
				shark.count = 0;
			}
			arr[shark.x][shark.y] = 0;
			shark.x = lastFish.x;
			shark.y = lastFish.y;
			arr[lastFish.x][lastFish.y] = shark.size;

			List<Fish> newFishList = new LinkedList<>();
			
			for(Fish fish : fishList) {
				if(fish.x == lastFish.x && fish.y == lastFish.y && fish.size == lastFish.size) {
					continue;
				}else {
					newFishList.add(fish);
				}
			}
			
			fishList = newFishList;
			
			return lastDistance;
		}
		
		return 0;
	}
	
	private static int bfs(Fish nowFish) {
		int[][] visit = new int[n][n];
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(shark.x, shark.y));
		visit[shark.x][shark.y] = 1;

		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			if (p.x == nowFish.x && p.y == nowFish.y) {
				return visit[nowFish.x][nowFish.y];
			}
			for (int i = 0; i < 4; i++) {
				int nx = DX[i] + p.x;
				int ny = DY[i] + p.y;
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (visit[nx][ny] == 0) {
						if (arr[nx][ny] <= shark.size) {
							queue.add(new Pair(nx, ny));
							visit[nx][ny] = visit[p.x][p.y] + 1;
						}
					}
				}
			}
		}

		return Integer.MAX_VALUE;
	}
	
	private static class Pair {
		private int x;
		private int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
	}
	
	private static class Shark {
		private int x;
		private int y;
		private int size = 2;
		private int count = 0;
		
		public Shark(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", size=" + size + ", count=" + count + "]";
		}
	}
	
	private static class Fish implements Comparable<Fish> {
		private int x;
		private int y;
		private int size;
		
		public Fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
		@Override
		public int compareTo(Fish o) {
			if (this.x < o.x)
				return -1;
			else if (this.x > o.x)
				return 1;
			else {
				return this.y - o.y;
			}
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", size=" + size + "]";
		}
	}

	/**
	 * n *n  크기의 공간에 물고기 M 마리와 아기 상어 1마리가 있다.
	 * 
	 * 공간은 1 * 1 정사각형으로 나누어져 있다.
	 * 한 칸에는 물고기가 최대 1마리 있다.
	 * 
	 * 아기 상어와 물고기는 모두 크기를 가지고 있다. 이 크기는 자연수 이다.
	 * 
	 * 가장 처음에 아기 상어의 크기는 2이다.
	 * 아기 상어는 1초에 상하좌우 인접한 한 칸씩 이동한다.
	 * 
	 * 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없다.
	 * 나머지 킨은 모두 지나갈 수 있다.
	 * 
	 * 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
	 * 
	 * 따라서 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
	 * 
	 * 아기 상어가 어디로 이동할 지 결정하는 방법은 아래와 같다.
	 * 
	 * 1. 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마를 부른다.
	 * 
	 * 2. 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
	 * 
	 * 3. 먹을 수 있는 물고기가 1마리 보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
	 * 
	 * 3-1. 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야 하는 칸의 갯수의 최솟값이다.
	 * 3-2. 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기(x가 작은), 
	 * 그러한 물고기가 여러 마리라면 가장 왼쪽에 있는 물고기를 먹는다.
	 * 
	 * 아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다.
	 * 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다.
	 * 물고기를 먹으면 그 칸은 빈칸이 된다.
	 * 
	 * 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다.
	 * 예를 들어 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.
	 * 
	 * 공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹는가
	 */
}
