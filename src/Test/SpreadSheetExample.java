package Test;

import org.junit.Test;

import java.util.List;

public class SpreadSheetExample {

    @Test
    public void spreadSheet(){
        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/Example_Spreadsheet.xlsx");
        List<String> row = sheetReader.readRow(1, "Input Data");

        for(String cell : row){
            System.out.println(cell);
        }


    }


}