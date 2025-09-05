package com.example;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import org.example.ChatApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.List;

@SpringBootTest(classes = ChatApp.class)
public class RAGTest {
    @Test
    public void testReadDocument() {
        // 使用FileSystemDocumentLoader读取指定目录下的知识库文档
        // 并使用默认的文档解析器TextDocumentParser对文档进行解析
        Document document = FileSystemDocumentLoader.loadDocument("D:\\AppDocument\\knowledge\\测试.txt");
        System.out.println(document.text());

        System.out.println("-------------------------------------------");
        // 加载单个文档
        Document document1 = FileSystemDocumentLoader.loadDocument("D:\\AppDocument\\knowledge\\科室信息.txt",
                new TextDocumentParser());
        System.out.println(document1.text());

        // 从一个目录中加载所有文档
        List<Document> documents = FileSystemDocumentLoader.loadDocuments("D:\\AppDocument\\knowledge",
                new TextDocumentParser());

        // 从一个目录中加载所有的.txt文档
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        List<Document> documents1 = FileSystemDocumentLoader.loadDocuments("D:\\AppDocument\\knowledge",
                pathMatcher, new TextDocumentParser());

        // 从一个目录及其子目录中加载所有文档
        List<Document> documents2 =
                FileSystemDocumentLoader.loadDocumentsRecursively("D:\\AppDocument\\knowledge",
                        new TextDocumentParser());
    }

    @Test
    public void testReadDocuments() {
        // 从一个目录中加载所有文档
        List<Document> documents = FileSystemDocumentLoader.loadDocuments("D:\\AppDocument\\knowledge",
                new TextDocumentParser());

        for (Document document : documents) {
            System.out.println("--------------------");
            System.out.println(document.metadata());
            System.out.println(document.text());

        }

//        // 从一个目录中加载所有的.txt文档
//        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
//        List<Document> documents1 = FileSystemDocumentLoader.loadDocuments("D:\\AppDocument\\knowledge",
//                pathMatcher, new TextDocumentParser());
//
//        // 从一个目录及其子目录中加载所有文档
//        List<Document> documents2 =
//                FileSystemDocumentLoader.loadDocumentsRecursively("D:\\AppDocument\\knowledge",
//                        new TextDocumentParser());
    }

    /**
     * 解析PDF
     */
    @Test
    public void testParsePDF() {
        Document document = FileSystemDocumentLoader.loadDocument("D:\\\\AppDocument\\\\knowledge\\医院信息.pdf",
                new ApachePdfBoxDocumentParser()
        );
        System.out.println(document);
    }
}
