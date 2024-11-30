package dados;

import model.Pais;
import java.util.ArrayList;
import java.util.List;

public class PaisesData {

    public static List<Pais> obterPaisesDaAmericaDoSul() {
        List<Pais> paises = new ArrayList<>();

        paises.add(new Pais("Argentina", "ARG", 45376763, 2780400));  // 2.780.400 km²
        paises.add(new Pais("Bolívia", "BOL", 11673021, 1098581));   // 1.098.581 km²
        paises.add(new Pais("Brasil", "BRA", 213993437, 8515767));   // 8.515.767 km²
        paises.add(new Pais("Chile", "CHL", 19250800, 756102));      // 756.102 km²
        paises.add(new Pais("Colômbia", "COL", 50882891, 1141748));  // 1.141.748 km²
        paises.add(new Pais("Equador", "ECU", 17643060, 283561));    // 283.561 km²
        paises.add(new Pais("Guiana", "GUY", 786508, 214969));       // 214.969 km²
        paises.add(new Pais("Paraguai", "PRY", 7132538, 406752));    // 406.752 km²
        paises.add(new Pais("Peru", "PER", 33109134, 1285216));      // 1.285.216 km²
        paises.add(new Pais("Suriname", "SUR", 618040, 163820));     // 163.820 km²
        paises.add(new Pais("Uruguai", "URY", 3480222, 176215));     // 176.215 km²
        paises.add(new Pais("Venezuela", "VEN", 28435943, 916445));  // 916.445 km²

        return paises;
    }
}
