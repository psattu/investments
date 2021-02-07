package com.tandra.investment.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

@Service
public class StocksFileService {

    private static final String stockFileDbName ="stocklist.txt";
    private static final String stockFileDbTempName ="stocklist_temp.txt";
    public Set<String> readStockListFromFile() {
        Set<String > stockList = new HashSet<>();
        String line;
        try {
            ClassPathResource res = new ClassPathResource(stockFileDbName);
            File file = new File(res.getPath());
             BufferedReader input =  new BufferedReader(new FileReader(file.getName()));
            if(!input.ready()){
                return stockList;
            }
            while((line = input.readLine()) != null ){
                stockList.add(line);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stockList;
    }
    public void addStockToFile(String stockSticker) throws IOException {
             BufferedWriter bw ;
             ClassPathResource res = new ClassPathResource(stockFileDbName);
            File file = new File(res.getPath());
            bw = new BufferedWriter( new FileWriter(file.getName(),true) );
            bw.write(stockSticker);
            bw.flush();
            bw.newLine();
            bw.close();

    }
    public void deleteStockByStickerID(String stickerId) throws IOException {
        String  record;
        ClassPathResource res = new ClassPathResource(stockFileDbName);
        File db = new File(res.getPath());
        ClassPathResource resTempDb = new ClassPathResource(stockFileDbTempName);
        File tempDB = new File(resTempDb.getPath());
        BufferedReader br = new BufferedReader( new FileReader( db ) );
        BufferedWriter bw = new BufferedWriter( new FileWriter( tempDB ) );
        while( ( record = br.readLine() ) != null ) {
           if( record.contains(stickerId) )
              continue;
            bw.write(record);
            bw.flush();
            bw.newLine();
        }
        br.close();
        bw.close();
        db.delete();
        tempDB.renameTo(db);

    }

    /*public void writeStockListIntoFile(Set<String> stockList){
        try {
            FileWriter fileWriter = new FileWriter("stocklist.txt");
            Writer output =  new BufferedWriter(fileWriter);
            for (String s : stockList) {
                output.write(s +"\n");
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/



}
