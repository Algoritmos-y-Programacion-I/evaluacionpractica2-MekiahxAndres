package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {

        pillars = new Pillar[4];
        precargaDeInformacion();

    }

    public void precargaDeInformacion() {

        Pillar biodiversidad = new Pillar("1.Biodiversidad");
        pillars[0] = biodiversidad;

        Pillar agua = new Pillar("2.Agua");
        pillars[1] = agua;

        Pillar tratamientoBasuras = new Pillar("3.Tratamineto de Basuras");
        pillars[2] = tratamientoBasuras;

        Pillar energia = new Pillar("4.Energia");
        pillars[3] = energia;
    }

    
    
    
    public String listadoPillars() {

        String lista = "";
        boolean validar = false;

        for (int j = 0; j < pillars.length; j++) {
            if (pillars[j] != null) {
                lista += "\n" + pillars[j].getName();
                validar = true;
            }
        }

        if (!validar) {
            lista = "No hay Pilares registrados";
        }

        return lista;

    }


    public Pillar searchPillar(String pillarType){

        for(int k=0;k<pillars.length;k++){

            if(pillars[k]!=null){
                if(pillars[k].getName().equalsIgnoreCase(pillarType)){
                    return pillars[k];
                }
            }
        }
        return null;

    }

    public String showPillar(String pillarType){

        for(int k=0;k<pillars.length;k++){

            if(pillars[k]!=null){
                if(pillars[k].getName().equalsIgnoreCase(pillarType)){
                    return pillars[k].toString();
                }
            }
        }

        return null;
    }



    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Prject en el Pillar, false en caso
     *         contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description,boolean status) {

        if (pillarType >= 0 && pillarType < pillars.length) {
            Project project = new Project(id, name, description, status); // Crear el objeto Project con el status
            return pillars[pillarType].addProject(project); // Añadir el proyecto al Pilar
        }

        return false;
    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     *         Project registrados en el Pillar
     */
    public String queryProjectsByPillar(int pillarType) {

        String query = "";
        if (pillarType >= 0 && pillarType < pillars.length) {
            Pillar pillar = pillars[pillarType];
            return pillar.getProjectList();
        } else {
            return "El pilar que has consultado no existe.";
        }

    }

}