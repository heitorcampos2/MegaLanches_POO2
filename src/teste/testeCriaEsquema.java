package teste;

import javax.persistence.EntityManager;
import util.JPAUtil;

public class testeCriaEsquema {

    public static void main(String[] args) {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

    }
}
