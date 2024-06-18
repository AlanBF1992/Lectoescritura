import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        crearArchivo("directorio", "fichero.txt");
        buscarTexto("src/directorio/fichero.txt", "Gato");
    }

    public static void crearArchivo(String directorio, String fichero) {
        File carpeta = new File("src/" + directorio);
        File archivo = new File("src/" + directorio + "/" + fichero);
        boolean worked;
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Directorio creado");
                if (!archivo.exists()) {
                    try {
                        boolean crearArchivo = archivo.createNewFile();

                        ArrayList<String> lista = new ArrayList<String>();
                        lista.add("Perro");
                        lista.add("Gato");
                        lista.add("Juan");
                        lista.add("Daniel");
                        lista.add("Juan");
                        lista.add("Gato");
                        lista.add("Perro");
                        lista.add("Camila");
                        lista.add("Daniel");
                        lista.add("Camila");

                        FileWriter fw = new FileWriter(archivo);
                        BufferedWriter bw = new BufferedWriter(fw);

                        for (String s : lista) {
                            bw.write(s);
                            bw.newLine();
                        }

                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Error al crear directorio");
            }
        } else {
            System.out.println("La carpeta ya existe");
        }
    }

    public static void buscarTexto(String nombreFichero, String texto) {
        File archivo = new File(nombreFichero);
        if (!archivo.exists()) {
            System.out.println("El fichero ingresado no existe");
            return;
        }
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            int repeticiones = Arrays.stream(br.lines().toArray()).filter(x -> ((String) x).equals(texto)).toArray().length;

            System.out.print("cantidad de repeticiones del texto -> ");
            System.out.println(repeticiones);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}