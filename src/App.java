import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // Declaraciones y asignaciones
        int intentosMaximos = 10;
        int intentos = 0;
        String palabraSecreta = "inteligencia";
        boolean estaAdivinada = false;

        // Arreglos:
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // Estructura de control de tipo iterativa.
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
            //System.out.print(letrasAdivinadas[i]);
        }

        // Estructura de control de tipo iterativa.
        while (!estaAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar: " +  String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            
            // Usamos un cuadro de diálogo para pedir al usuario una letra
            char letra = Character.toLowerCase(JOptionPane.showInputDialog("Ingrese una letra, por favor").charAt(0));

            boolean esLetraCorrecta = false;

            // Estructura de control: Iterativa (bucle)
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    esLetraCorrecta = true;
                }
            }

            if (!esLetraCorrecta) {
                intentos ++;
                System.out.println("¡Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                estaAdivinada = true;
                System.out.println("¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
            }
        }

        if (!estaAdivinada) {
            System.out.println("Qué pena, te has quedado sin intentos");
        }
    }
}
