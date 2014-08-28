import java.io.Serializable;

public class Cereal implements Serializable {

	private static final long serialVersionUID = 7146604787333107575L;
	private boolean isTasty;
	private String name;

	public Cereal(String name, boolean isTasty) {
		this.isTasty = isTasty;
		this.name = name;

	}

	@Override
	public String toString() {
		return name;
	}

}
