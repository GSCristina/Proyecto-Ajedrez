package DataAccess;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLManager {
    public static <T> boolean writeXML(T t, String fileName){
        boolean result= false;
        //Proceso de serializacion de forma generica con T
        //Creamos un contexto en JaxB
        try {
            JAXBContext context = JAXBContext.newInstance(t.getClass());
            //Para serializar debemos crear un Marshaller usando el contexto creado antes
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true); //Para estructurar
            marshaller.marshal(t,new File(fileName)); //Esto cambia


            result=true;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public static <T> T readXML(T t, String fileName){
        T result = t;
        //Proceso de deserialización UnMarshall
        try {
            JAXBContext context = JAXBContext.newInstance(t.getClass());
            Unmarshaller unmarshaller = context.createUnmarshaller();

            result = (T) unmarshaller.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}