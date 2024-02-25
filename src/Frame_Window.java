package My_Gui_Calculator_pack;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame_Window extends Frame{
    private static ArrayList<String> Al = new ArrayList<String>(),Al2 = new ArrayList<String>();
    private Panel p[];
    private Button b[];
    private Float result = 0f;
    public TextArea t;
    Dimension panel;
    private Color Cbutton,Cbuttonf,Ctext;
    private Font Fbutton,textf,sic;
    private My_ActionListener a;
    private BorderLayout p6,p2,p9,p11;
    private GridLayout frame = new GridLayout(2,1),p0,p7,p12,p14;
    private boolean enabled = false;
    public Frame_Window(){
        setTitle("My Calculator");
        setVisible(true);
        setSize(336,541);
        setLocation(750, 250);
        setLayout(frame);
        initialize();
        addComponent();
        addWindowListener(new My_WindowListener());
        equels();
    }
    public void initialize(){
        panel = new Dimension(10,10);
        t = new TextArea("",1,30,TextArea.SCROLLBARS_NONE);
        b = new Button[35];
        Cbutton = new Color(0xFFFFF7);
        Cbuttonf = new Color(0xF5761A);
        Ctext = new Color(0xD6D4D7);
        p0 = new GridLayout(2,1,0,100);
        p2 = new BorderLayout();
        p6 = new BorderLayout();
        p7 = new GridLayout(5,4,4,4);
        p9 = new BorderLayout(0,4);
        p11 = new BorderLayout(0,4);
        p12 = new GridLayout(5,1,0,4);
        p14 = new GridLayout(2,5,4,4);
        Fbutton = new Font("Passion One",1,18);
        textf = new Font("Passion One",1,24);
        sic = new Font("Noto Serif Toto",1,16);
        b[0] = new Button("AC");
        b[1] = new Button("C");
        b[2] = new Button("%");
        b[3] = new Button("/");
        b[4] = new Button("7");
        b[5] = new Button("8");
        b[6] = new Button("9");
        b[7] = new Button("X");
        b[8] = new Button("4");
        b[9] = new Button("5");
        b[10] = new Button("6");
        b[11] = new Button("-");
        b[12] = new Button("1");
        b[13] = new Button("2");
        b[14] = new Button("3");
        b[15] = new Button("+");
        b[16] = new Button("S");
        b[17] = new Button("0");
        b[18] = new Button(".");
        b[19] = new Button("=");
        b[20] = new Button("√x");
        b[21] = new Button("x!");
        b[22] = new Button("1/x");
        b[23] = new Button("∏");
        b[24] = new Button("e");
        b[25] = new Button("2nd");
        b[26] = new Button("deg");
        b[27] = new Button("sin");
        b[28] = new Button("cos");
        b[29] = new Button("tan");
        b[30] = new Button("x^y");
        b[31] = new Button("lg");
        b[32] = new Button("ln");
        b[33] = new Button("(");
        b[34] = new Button(")");
        p = new Panel[17];
        p[0] = new Panel(p0);
        p[1] = new Panel();
        p[2] = new Panel(p2);
        p[3] = new Panel();
        p[4] = new Panel();
        p[5] = new Panel();
        p[6] = new Panel(p6);
        p[7] = new Panel(p7);
        p[8] = new Panel();
        p[9] = new Panel(p9);
        p[10] = new Panel();
        p[11] = new Panel(p11);
        p[12] = new Panel(p12);
        p[13] = new Panel();
        p[14] = new Panel(p14);
        p[15] = new Panel();
        p[16] = new Panel();
        Al.add("0");
        Al.add("+");
        a = new My_ActionListener(this);
    }
    public void addComponent(){
        //upper section
        add(p[0]);
        p[0].add(p[1]);
        p[0].add(p[2]);
        p[2].add(t,BorderLayout.CENTER);
        p[2].add(p[3],BorderLayout.EAST);
        p[3].setPreferredSize(panel);
        p[2].add(p[4],BorderLayout.WEST);
        p[4].setPreferredSize(panel);
        p[2].add(p[5],BorderLayout.SOUTH);
        p[5].setPreferredSize(panel);
        t.setEditable(false);
        t.setFont(textf);
        t.setBackground(Ctext);
        //lower section
        add(p[6]);
        p[6].add(p[7],BorderLayout.CENTER);
        for(int i=0;i<b.length;i++){
            b[i].setBackground(Cbutton);
            b[i].setFont(Fbutton);
            if(i<=19)p[7].add(b[i]);
            b[i].addActionListener(a);
        }
        b[0].setForeground(Cbuttonf);
        b[1].setForeground(Cbuttonf);
        b[2].setForeground(Cbuttonf);
        b[3].setForeground(Cbuttonf);
        b[7].setForeground(Cbuttonf);
        b[11].setForeground(Cbuttonf);
        b[15].setForeground(Cbuttonf);
        b[16].setForeground(Cbuttonf);
        b[19].setBackground(Cbuttonf);
        b[19].setForeground(Cbutton);
        b[20].setForeground(Color.GRAY);
        b[21].setForeground(Color.GRAY);
        b[22].setForeground(Color.GRAY);
        b[23].setForeground(Color.GRAY);
        b[24].setForeground(Color.GRAY);
        b[25].setForeground(Color.GRAY);
        b[26].setForeground(Color.GRAY);
        b[27].setForeground(Color.GRAY);
        b[28].setForeground(Color.GRAY);
        b[29].setForeground(Color.GRAY);
        b[30].setForeground(Color.GRAY);
        b[31].setForeground(Color.GRAY);
        b[32].setForeground(Color.GRAY);
        b[33].setForeground(Color.GRAY);
        b[34].setForeground(Color.GRAY);
        //padding
        p[6].add(p[8],BorderLayout.EAST);
        p[8].setPreferredSize(panel);
        p[6].add(p[9],BorderLayout.WEST);
        p[9].setPreferredSize(panel);
        p[6].add(p[10],BorderLayout.SOUTH);
        p[6].add(p[11],BorderLayout.NORTH);
    }
    //logic
    private void bodmas(){
        String s;
        Al2.addAll(Al);
        for(int i=0;i<Al.size();i++){
            s=Al.get(i);
            if(s.equals("X")){
                Al2.set(Al2.indexOf("X")-1,Float.toString(Float.parseFloat(Al2.get(Al2.indexOf("X")-1))*Float.parseFloat(Al2.get(Al2.indexOf("X")+1))));
                Al2.remove(Al2.indexOf("X")+1);
                Al2.remove(Al2.indexOf("X"));
            }
            else if(s.equals("/")){
                Al2.set(Al2.indexOf("/")-1,Float.toString(Float.parseFloat(Al2.get(Al2.indexOf("/")-1))/Float.parseFloat(Al2.get(Al2.indexOf("/")+1))));
                Al2.remove(Al2.indexOf("/")+1);
                Al2.remove(Al2.indexOf("/"));
            }
        }
    }
    public void keypressed(String key){
        if(key.equals("+")||key.equals("-")||key.equals("X")||key.equals("/")){
            if(Al.size()==2){java.awt.Toolkit.getDefaultToolkit().beep();return;}
            t.append(key);
            Al.add(key);
        }
        else if(key.equals("∏")){
            if(t.getText().equals("0")&&Al.size()==2)t.setText("");
            if(Al.get(Al.size()-1).equals("+")||Al.get(Al.size()-1).equals("-")||Al.get(Al.size()-1).equals("*")||Al.get(Al.size()-1).equals("/")){
                t.append(key);
                Al.add(Double.toString(Math.PI));
                update();
            }
        }
        else{
            if(t.getText().equals("0")&&Al.size()==2)t.setText("");
            if(Al.get(Al.size()-1).equals("-0")){Al.remove(Al.size()-1);t.append(key);Al.add("-"+key);}
            else if(Al.get(Al.size()-1).equals("+")||Al.get(Al.size()-1).equals("-")||Al.get(Al.size()-1).equals("X")||Al.get(Al.size()-1).equals("/")||Al.get(Al.size()-1).equals("^")){t.append(key);Al.add(key);}
            else {
                if(Al.get(Al.size()-1).equals(Double.toString(Math.PI))){java.awt.Toolkit.getDefaultToolkit().beep();return;}
                t.append(key);Al.set(Al.size()-1,Al.get(Al.size()-1).concat(key));
            }
            update();
            // System.out.println(result);
        }

    }
    public void update(){
        bodmas();
        result=Float.parseFloat(Al2.get(0));
        if(Al.size()<=2)return;
        for(int i=1;i<Al2.size();i+=2){
            switch(Al2.get(i)){
                case "+"-> result+=Float.parseFloat(Al2.get(i+1));
                case "-"-> result-=Float.parseFloat(Al2.get(i+1));
                case "^"-> {
                    String temp  = Al.remove(Al.size()-1);
                    String temp2 = Al.remove(Al.size()-1);
                    String temp3 = Al.remove(Al.size()-1);
                    String temp4 = Al.remove(Al.size()-1);
                    update();
                    Al.add(temp4);
                    Al.add(temp3);
                    Al.add(temp2);
                    Al.add(temp);
                    switch(temp4){
                        case "+"-> result+=(float)Math.pow(Float.parseFloat(temp3),Float.parseFloat(temp));
                        case "-"-> result-=(float)Math.pow(Float.parseFloat(temp3),Float.parseFloat(temp));
                        case "X"-> result+=(float)Math.pow(Float.parseFloat(temp3),Float.parseFloat(temp));
                        case "/"-> result-=(float)Math.pow(Float.parseFloat(temp3),Float.parseFloat(temp));
                    }
                }
            }
        }
        Al2.clear();
    }
    public void modulus(){
        if(Al.size()>2){
            String temp = Al.remove(Al.size()-1);
            String temp2 = Al.remove(Al.size()-1);
            update();
            Al.add(temp2);
            Al.add(Float.toString((Float.parseFloat(temp)/100f)*result));
            update();
        }
        else{
            result = (Float.parseFloat(t.getText().substring(0,t.getText().length())))/100f;
            t.setText(result.toString());
            Al.removeAll(Al);
            Al.add(result.toString());
        }
    }
    public void npow(){
        if(Al.size()>=2){
            t.append("^-1");
            Al.add("^");
            Al.add("-1");
            update();
        }
    }
    //other keys
    // static void print(List<String> Al){
    //     for(String s:Al)
    //       System.out.println(s);
    // }
    public void clearText(){
        t.setText(new StringBuffer(t.getText()).deleteCharAt(t.getText().length()-1).toString());
        if(Al.get(Al.size()-1).length()-1!=0){
            if(Al.get(Al.size()-1).length()==2)
                if(Al.get(Al.size()-1).charAt(0)=='-'&&Al.get(Al.size()-1).charAt(1)!='0'){
                    Al.remove(Al.size()-1);
                    Al.add("-0");
                    return;
                }
            if(Al.get(Al.size()-1).length()==2&&Al.get(Al.size()-1).equals("-0")){Al.remove(Al.size()-1);return;}
            Al.set(Al.size()-1,new StringBuffer(Al.get(Al.size()-1)).deleteCharAt(Al.get(Al.size()-1).length()-1).toString());
        }
        else if(Al.size()>2)Al.remove(Al.size()-1);
        update();
        // equels();
    }
    public void clear(){
        t.setText(new StringBuffer(t.getText()).delete(0,t.getText().length()).toString());
        Al.clear();
        Al.add("0");
        Al.add("+");
        result=0f;
        equels();
    }
    public boolean floatint(){
        if(result>result.intValue())
            return true;
        return false;
    }
    public void equels(){
        Integer i;
        Al.removeAll(Al);
        Al.add("0");
        Al.add("+");
        if(floatint()){t.setText(result.toString());Al.add(result.toString());}
        else {
            i = result.intValue();
            t.setText(i.toString());
            if(t.getText().equals("0")&&Al.size()==2)return;
            Al.add(i.toString());
        }
    }
    public void scientific(){
        if(!enabled){
            p6.setHgap(4);
            p6.setVgap(4);
            p[9].setPreferredSize(new Dimension(68,0));
            p[11].setPreferredSize(new Dimension(0,68));
            p[8].setPreferredSize(new Dimension(5,0));
            p[9].setFont(sic);
            p[11].setFont(sic);
            for(int i=0;i<20;i++)b[i].setFont(Fbutton.deriveFont(16));
            p[9].add(p[12],BorderLayout.CENTER);
            p[9].add(p[13],BorderLayout.WEST);
            p[11].add(p[14],BorderLayout.CENTER);
            p[11].add(p[15],BorderLayout.EAST);
            p[11].add(p[16],BorderLayout.WEST);
            p[12].add(b[20]);
            p[12].add(b[21]);
            p[12].add(b[22]);
            p[12].add(b[23]);
            p[12].add(b[24]);
            p[14].add(b[25]);
            p[14].add(b[26]);
            p[14].add(b[27]);
            p[14].add(b[28]);
            p[14].add(b[29]);
            p[14].add(b[30]);
            p[14].add(b[31]);
            p[14].add(b[32]);
            p[14].add(b[33]);
            p[14].add(b[34]);
            setSize(336+1,541+1);
            setSize(336,541);
            enabled=true;
            b[16].setLabel("N");
        }
        else{
            for(int i=0;i<20;i++)b[i].setFont(Fbutton);
            p[9].remove(p[12]);
            p[11].remove(p[14]);
            p6.setHgap(0);
            p[9].setPreferredSize(new Dimension(10,0));
            p[8].setPreferredSize(new Dimension(10,0));
            p[11].setPreferredSize(new Dimension(10,0));
            setSize(336+1,541+1);
            setSize(336,541);
            enabled=false;
            b[16].setLabel("S");
        }
    }
}