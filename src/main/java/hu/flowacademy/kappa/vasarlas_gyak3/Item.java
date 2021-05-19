package hu.flowacademy.kappa.vasarlas_gyak3;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private final int id;
    private final String tv;
    private final double price;
}
