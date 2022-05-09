package es.iespuerto.ets;

import org.junit.jupiter.api.*;

public class UsuarioTest {
    Usuario marcos = null;
    Usuario leia = null;
    Usuario yanira = null;
    Usuario antonio = null;

    @BeforeEach
    public void beforeEach() throws Exception {
        marcos = new Usuario("marcosdelafuente93@gmail.com", "MarquitoS_93#");
        leia = new Usuario("leiaOrgana@hotmail.com", "SkywalkerEsMiPadre?19_ABY");
        yanira = new Usuario("yaniraHerGonz@gobiernodecanarias.org", "YanHerGonz-45/12/04");
        antonio = new Usuario("a@gmail.com", "alejandoPorQue??7612");
    }

    @Test
    public void exceptionUsuarioTest() {
        Exception thrownEmail = Assertions.assertThrows(Exception.class, () -> marcos = new Usuario("emailIncorrecto@yahoo.com","MarquitoS_93#"));
        Assertions.assertTrue(thrownEmail.getMessage().contains("Su email debe ser '@gmail.com', '@hotmail.com' o '@gobiernodecanarias.org'."));

        Exception thrownContraConDigitos = Assertions.assertThrows(Exception.class, () -> marcos = new Usuario("email@gmail.com","estanofuncionacondigitos1221"));
        Assertions.assertTrue(thrownContraConDigitos.getMessage().contains("Su contraseña no cumple los siguientes requisitos:\n - Minimo 1 caracter en mayusculas."));
    }

    @Test
    public void getEmailTest() {
        Assertions.assertEquals("marcosdelafuente93@gmail.com", marcos.getEmail());
        Assertions.assertEquals("leiaOrgana@hotmail.com", leia.getEmail());
        Assertions.assertEquals("yaniraHerGonz@gobiernodecanarias.org", yanira.getEmail());
    }

    @Test
    public void setEmail() throws Exception {
        String newEmailMarcos = "123456789@gobiernodecanarias.org";
        marcos.setEmail(newEmailMarcos);
        String newEmailLeia = "987654321@gmail.com";
        leia.setEmail(newEmailLeia);
        String newEmailYanira = "214365879@hotmail.com";
        yanira.setEmail(newEmailYanira);

        Assertions.assertEquals(newEmailMarcos, marcos.getEmail());
        Assertions.assertEquals(newEmailLeia, leia.getEmail());
        Assertions.assertEquals(newEmailYanira, yanira.getEmail());
    }

    @Test
    public void getPasswordTest() {
        Assertions.assertEquals("MarquitoS_93#",marcos.getPassword());
        Assertions.assertEquals("SkywalkerEsMiPadre?19_ABY",leia.getPassword());
        Assertions.assertEquals("YanHerGonz-45/12/04",yanira.getPassword());
    }

    @Test
    public void setPasswordTest() throws Exception{
        String newContraMarcos = "SoyelMejor123!!";
        marcos.setPassword(newContraMarcos);
        String newContraLeia = "1122 DefinitivamenteEsMiPadre:)";
        leia.setPassword(newContraLeia);
        String newContraYanira = "NuevaContraseña1234??";
        yanira.setPassword(newContraYanira);

        Assertions.assertEquals(newContraMarcos, marcos.getPassword());
        Assertions.assertEquals(newContraLeia, leia.getPassword());
        Assertions.assertEquals(newContraYanira, yanira.getPassword());
    }

    @Test
    public void exceptionValidarEmailTest() {
        String newEmailMarcos = "emailIncorrecto@yahoo.com";
        
        Exception thrown = Assertions.assertThrows(Exception.class, () -> marcos.setEmail(newEmailMarcos));
        Assertions.assertTrue(thrown.getMessage().contains("Su email debe ser '@gmail.com', '@hotmail.com' o '@gobiernodecanarias.org'."));
    }

    @Test
    public void exceptionRequisitosPasswordTest() {
        String newContraMarcos = "estanofuncionacondigitos1221";
        String newContraLeia = "ESTANOFUNCIONACONTODOMAYUSCULAS12";
        String newContraYanira = "estanofuncionaconMAYUSCULAS";
        String newContraAntonio = "AA12";

        Exception thrownConDigitos = Assertions.assertThrows(Exception.class, () -> marcos.setPassword(newContraMarcos));
        Assertions.assertTrue(thrownConDigitos.getMessage().contains("Su contraseña no cumple los siguientes requisitos:\n - Minimo 1 caracter en mayusculas."));
        
        Exception thrownConEspeciales = Assertions.assertThrows(Exception.class, () -> leia.setPassword(newContraLeia));
        Assertions.assertTrue(thrownConEspeciales.getMessage().contains("Su contraseña no cumple los siguientes requisitos:\n - Minimo 1 caracter en minusculas."));
        
        Exception thrownConMayusculas = Assertions.assertThrows(Exception.class, () -> yanira.setPassword(newContraYanira));
        Assertions.assertTrue(thrownConMayusculas.getMessage().contains("Su contraseña no cumple los siguientes requisitos:\n - Minimo 1 digito."));
        
        Exception thrownSinLongitudMin = Assertions.assertThrows(Exception.class, () -> antonio.setPassword(newContraAntonio));
        Assertions.assertTrue(thrownSinLongitudMin.getMessage().contains("Su contraseña no cumple los siguientes requisitos:\n - Al menos 6 caracteres."));
    }
}
