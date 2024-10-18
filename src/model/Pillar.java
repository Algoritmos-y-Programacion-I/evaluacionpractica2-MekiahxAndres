package model;

public class Pillar {

    private String name;
    private Project[] projects;

    public Pillar(String name) {
        this.name = name;
        projects = new Project[50];
    }

    

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public Project[] getProjects() {
        return projects;
    }



    public void setProjects(Project[] projects) {
        this.projects = projects;
    }



    /**
     * Descripcion: Añade un nuevo Project al arreglo projects
     * pre: El arreglo projects debe estar inicializado
     * pos: El arreglo projects queda modificado con el nuevo Project
     * agregado
     * 
     * @param newProject Project El Project que se va a añadir
     * @return boolean true si se logra añadir el Project, false en caso
     *         contrario
     */
    public boolean addProject(Project project) {
        
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] == null) {
                projects[i] = project;  // Asigna el proyecto en la primera posición vacía
                System.out.println("Proyecto añadido: " + project.getName());  // Imprimir para verificar
                return true;
            }
        }
        return false;  // No hay espacio para más proyectos
    }

    /**
     * Descripcion: Genera una cadena en formato lista con la información de los
     * Project registrados en el Pillar
     * pre: El arreglo projects debe estar inicializado
     * 
     */
    public String getProjectList() {
        String list = "";
        boolean hasProjects = false;
    
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
                list += "ID: " + projects[i].getId() + " - " + projects[i].getName() + "\n";
                hasProjects = true;
            }
        }
    
        if (!hasProjects) {
            list = "Este pilar no tiene proyectos registrados.\n";
        }
    
        return list;
    }

}
