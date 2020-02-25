//package com.javarush.task.task32.task3209;
//
//import javax.swing.text.BadLocationException;
//import javax.swing.text.html.HTMLDocument;
//import javax.swing.text.html.HTMLEditorKit;
//import java.io.File;
//import java.io.IOException;
//import java.io.StringReader;
//import java.io.StringWriter;
//
//public class Controller {
//    private View view;
//    private HTMLDocument document;
//    private File currentFile;
//
//    public Controller(View view) {
//        this.view = view;
//    }
//
//    public void init() {
//    }
//
//    public void exit() {
//        System.exit(0);
//    }
//
//    public HTMLDocument getDocument() {
//        return document;
//    }
//
//    public void resetDocument() {
//        if (document != null) {
//            document.removeUndoableEditListener(view.getUndoListener());
//        }
//        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
//        document.addUndoableEditListener(view.getUndoListener());
//        view.update();
//
//    }
//
//    public void setPlainText(String text) {
//        resetDocument();
//        StringReader stringReader = new StringReader(text);
//        HTMLEditorKit kit = new HTMLEditorKit();
//        try {
//            kit.read(stringReader, document, document.getTokenThreshold());
//
//        } catch (Exception e) {
//            ExceptionHandler.log(e);
//        }
//    }
//
//    public String getPlainText() {
//        try (StringWriter sw = new StringWriter()) {
//            new HTMLEditorKit().write(sw, document, 0, document.getLength());
//            return sw.toString();
//        } catch (IOException | BadLocationException e) {
//            ExceptionHandler.log(e);
//        }
//        return null;
//    }
//    public static void main(String[] args) {
//        View view = new View();
//        Controller controller = new Controller(view);
//        view.setController(controller);
//        view.init();
//        controller.init();
//    }
//
//}
package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        if (jFileChooser.showOpenDialog(view) == jFileChooser.APPROVE_OPTION) {
            resetDocument();
            view.resetUndo();
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileReader reader = new FileReader(currentFile)) {
                new HTMLEditorKit().read(reader, document, 0);
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile == null) {
            saveDocumentAs();
        } else {
            try (FileWriter writer = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        if (jFileChooser.showSaveDialog(view) == jFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter writer = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) (new HTMLEditorKit()).createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text) {
        resetDocument();
        try (StringReader sr = new StringReader(text)) {
            (new HTMLEditorKit()).read(sr, document, 0);
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        try (StringWriter sw = new StringWriter()) {
            new HTMLEditorKit().write(sw, document, 0, document.getLength());
            return sw.toString();
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return null;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        controller.view = view;
        view.setController(controller);
        view.init();
        controller.init();
    }

}