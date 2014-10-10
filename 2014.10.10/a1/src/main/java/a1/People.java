package a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Componet : version2
@Component
public class People {

	@Autowired
	private Snack snack;

	public void setSnack(Snack snack) {
		this.snack = snack;
	}

	@Override
	public String toString() {
		return "People [snack=" + snack + "]";
	}

}
