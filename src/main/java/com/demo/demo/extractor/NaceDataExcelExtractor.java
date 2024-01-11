package com.demo.demo.extractor;

import com.demo.demo.DemoApplication;
import com.demo.demo.entities.NaceEntity;
import com.demo.demo.model.DemoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class NaceDataExcelExtractor implements INaceDataExtractor {

    @Value("${nace.data.extractor.filename}")
    private String fileName;

    @Override
    public List<NaceEntity> getNaceData() throws DemoException{
        return getNaceData(this.fileName);
    }
    @Override
    public List<NaceEntity> getNaceData(String location) throws DemoException {

        List<NaceEntity> naceEntityList = new ArrayList<>();

        InputStreamReader fr;

        try {
            InputStream is = DemoApplication.class.getClassLoader().getResourceAsStream(location);
            fr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(fr);

            boolean isHeadersLine = true;
            //We read each line until the end of the file
            String line;
            while ((line = br.readLine()) != null) {
                //We use the separator
                String[] data = line.split(";");

                while(data.length<10){
                    line = br.readLine();
                    if(line.contains("\"") && line.contains(";")){
                        String[] dataAux = line.split(";");
                        data = concatArrays(data, dataAux);
                    }else{
                        data[data.length-1] = data[data.length-1]+line;
                    }
                }

                if(!isHeadersLine) {
                    NaceEntity entity = fullfillEntity(data);
                    naceEntityList.add(entity);
                }else{
                    //we skip the first line
                    isHeadersLine = false;
                }
            }
            //Exceptions
        } catch (Exception e) {
            throw new DemoException();

//        } finally {
//            try {
//                if (fr != null) {
//                    fr.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
        }
        return naceEntityList;
    }

    private String[] concatArrays (String[] data, String [] dataAux){
              String[] dataResult = new String[data.length + dataAux.length -1];
              for(int i=0; i<data.length-1; i++){
                  dataResult[i] = data[i];
              }

              dataResult[data.length-1] = dataResult[data.length-1]+dataAux[0];

              for(int i=1; i< dataAux.length; i++){
                  dataResult[data.length+i-1] = dataAux[i];
              }

              return dataResult;
          }

    private NaceEntity fullfillEntity(String[] datos) {
        NaceEntity entity = new NaceEntity();
        entity.setOrder(Long.valueOf(datos[0]));
        entity.setLevel(Integer.valueOf(datos[1]));
        entity.setCode(datos[2]);
        entity.setParent(datos[3]);
        entity.setDescription(datos[4]);
        entity.setItemIncludes(datos[5]);
        entity.setAlsoIncludes(datos[6]);
        entity.setRulings(datos[7]);
        entity.setItemExcludes(datos[8]);
        entity.setReferenceIsic(datos[9]);


       return entity;
    }


}
