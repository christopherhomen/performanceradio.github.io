//PERFORMANCE
package com.co;
import com.co.DAO.OyenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorInicio {
    
         //despues de crear mi Dao, debo inyectar mi clase al controlador.  //para inyectar a nuestra vista loginadmin, le damos Autowired: voy a usar mi propia clase
    @Autowired
    //instancia de clase:
    private OyenteDAO oyenteDao;
        
    //Muestre desde la posicion o raiz absoluta de la página :
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    
     //Cuando pida mostrar inicio de sesion va a hacer: 
    //para abrir la pagina 
    @GetMapping("/login")
      public String iniciosesion(){
        return "iniciosesion";
    }
     
        @GetMapping("/register")
      public String registro(){
        return "register";
    }
      
      //mapeo al login admin para que cuando bingrese muestre la pagina loginadmin
          @GetMapping("/loginadmin")
      public String loginamdin(Model model){
           //creo una variable usuarios
          //findall: listar
          var oyentes = oyenteDao.findAll();
          //va a compartir todos sus atributos: 
          model.addAttribute("oyentes", oyentes);
          //esto lo comparto con el loginadmin
        return "loginadmin";
    }
}
