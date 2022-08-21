package BinaryTree;

//演示所用数据类
public class Hero implements Comparable<Hero> {
    public int rank;
    public String name;
    public String nickname;

    public Hero() {
    }

    public Hero(int rank, String name, String nickname) {
        this.rank = rank;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public int getRank() {
        return rank;
    }

    @Override
    public int compareTo(Hero o) {
        return this.rank - o.rank;
    }
}
