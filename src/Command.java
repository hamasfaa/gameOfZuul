public class Command {
    private String kataPerintah;
    private String kataKedua;

    public Command(String kataPertama, String kataKedua){
        kataPerintah = kataPertama;
        this.kataKedua = kataKedua;
    }

    public String getCommandWord(){
        return kataPerintah;
    }

    public String getSecondWord(){
        return kataKedua;
    }

    public boolean isUnknown(){
        return (kataPerintah == null);
    }

    public boolean hasSecondWord(){
        return (kataKedua != null);
    }
}