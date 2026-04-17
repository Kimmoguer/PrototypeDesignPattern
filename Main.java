// Document interface
interface Document extends Cloneable {
    Document clone();
    void open();
}

// ===================== PDF DOCUMENT =====================
class PdfDocument implements Document {
    String fileName;
    String author;
    int pageCount;

    public PdfDocument() {
        System.out.println("Creating a PDF Document prototype.");
    }

    public PdfDocument(PdfDocument doc) {
        this.fileName = doc.fileName;
        this.author = doc.author;
        this.pageCount = doc.pageCount;
    }

    public Document clone() {
        return new PdfDocument(this);
    }

    public void open(String fileName, String author, int pageCount) {
        this.fileName = fileName;
        this.author = author;
        this.pageCount = pageCount;

        System.out.println("Opening PDF Document: " + fileName + " by " + author + " (" + pageCount + " pages)");
    }

    public void open() {}
}

// ===================== TEXT DOCUMENT =====================
class TextDocument implements Document {
    String filePath;
    String encoding;
    int wordCount;

    public TextDocument() {
        System.out.println("Creating a Text Document prototype.");
    }

    public TextDocument(TextDocument doc) {
        this.filePath = doc.filePath;
        this.encoding = doc.encoding;
        this.wordCount = doc.wordCount;
    }

    public Document clone() {
        return new TextDocument(this);
    }

    public void open(String filePath, String encoding, int wordCount) {
        this.filePath = filePath;
        this.encoding = encoding;
        this.wordCount = wordCount;

        System.out.println("Opening Text Document: " + filePath + " with encoding: " + encoding + " (" + wordCount + " words)");
    }

    public void open() {}
}

// ===================== SPREADSHEET DOCUMENT =====================
class SpreadsheetDocument implements Document {
    String name;
    int rows;
    int columns;

    public SpreadsheetDocument() {
        System.out.println("Creating a Spreadsheet Document prototype.");
    }

    public SpreadsheetDocument(SpreadsheetDocument doc) {
        this.name = doc.name;
        this.rows = doc.rows;
        this.columns = doc.columns;
    }

    public Document clone() {
        return new SpreadsheetDocument(this);
    }

    public void open(String name, int rows, int columns) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;

        System.out.println("Opening Spreadsheet Document: " + name + " (1000 rows, 20 columns)");
    }

    public void open() {}
}

// ===================== MAIN =====================
public class Main {
    public static void main(String[] args) {

        PdfDocument pdfPrototype = new PdfDocument();
        TextDocument textPrototype = new TextDocument();
        SpreadsheetDocument sheetPrototype = new SpreadsheetDocument();

        PdfDocument pdf1 = (PdfDocument) pdfPrototype.clone();
        pdf1.open("annual_report_2024.pdf", "Acme Corp", 150);

        TextDocument text1 = (TextDocument) textPrototype.clone();
        text1.open("meeting_notes.txt", "UTF-8", 250);

        SpreadsheetDocument sheet1 = (SpreadsheetDocument) sheetPrototype.clone();
        sheet1.open("sales_data_q1.xlsx", 1000, 20);

        PdfDocument pdf2 = (PdfDocument) pdfPrototype.clone();
        pdf2.open("summary_report.pdf", "Acme Corp", 30);
    }
}