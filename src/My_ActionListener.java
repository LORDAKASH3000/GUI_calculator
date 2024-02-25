package My_Gui_Calculator_pack;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;

public class My_ActionListener implements ActionListener{
    Frame_Window f;
    public My_ActionListener(Frame_Window f){
        this.f=f;
    }
    public void actionPerformed(ActionEvent e){
        Button b=(Button)e.getSource();
        switch(b.getLabel()){
            case "AC"->f.clear();
            case "C"->f.clearText();
            case "S","N"->{f.scientific();}
            case "1"->{f.keypressed("1");}
            case "2"->{f.keypressed("2");}
            case "3"->{f.keypressed("3");}
            case "4"->{f.keypressed("4");}
            case "5"->{f.keypressed("5");}
            case "6"->{f.keypressed("6");}
            case "7"->{f.keypressed("7");}
            case "8"->{f.keypressed("8");}
            case "9"->{f.keypressed("9");}
            case "0"->{f.keypressed("0");}
            case "%"->f.modulus();
            case "/"->{f.keypressed("/");}
            case "X"->{f.keypressed("X");}
            case "+"->{f.keypressed("+");}
            case "-"->{f.keypressed("-");}
            case "."->{f.keypressed(".");}
            case "="->f.equels();
            case "√x"->{f.keypressed("√x");}
            case "x!"->{f.keypressed("x!");}
            case "1/x"->{f.npow();}
            case "∏"->{f.keypressed("∏");}
            case "e"->{f.keypressed("e");}
            case "2n"->{f.keypressed("2nd");}
            case "de"->{f.keypressed("deg");}
            case "sin"->{f.keypressed("sin");}
            case "cos"->{f.keypressed("cos");}
            case "tan"->{f.keypressed("tan");}
            case "x^y"->{f.keypressed("x^y");}
            case "lg"->{f.keypressed("lg");}
            case "ln"->{f.keypressed("ln");}
            case "("->{f.keypressed("(");}
            case ")"->{f.keypressed(")");}
            default-> System.out.println(f.t.getText().length());
        }
    }
}
// class My_KeyListener extends KeyAdapter{
    
// }
class My_WindowListener extends WindowAdapter{
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}