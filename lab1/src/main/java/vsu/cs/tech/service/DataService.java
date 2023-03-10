package vsu.cs.tech.service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.TextSearchOptions;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.*;

import static com.mongodb.client.model.Filters.eq;

@Service
public class DataService {

    private Map<String ,String> setSubjectDescriptions() {
        Map<String, String> subjectDescriptions = new HashMap<>();
        subjectDescriptions.put("Электродинамика", "Электродина́мика — раздел физики, изучающий электромагнитное поле в наиболее общем случае и его взаимодействие с телами, имеющими электрический заряд.");
        subjectDescriptions.put("Разработка мобильных приложений", "Разработка приложений для мобильных устройств — это процесс, при котором приложения разрабатываются для небольших портативных устройств, таких, как КПК, смартфоны или сотовые телефоны. ");
        subjectDescriptions.put("Математический анализ", "Математи́ческий ана́лиз — совокупность разделов математики, соответствующих историческому разделу под наименованием «анализ бесконечно малых», объединяет дифференциальное и интегральное исчисления.");
        subjectDescriptions.put("Информационные технологии", " процессы, использующие совокупность средств и методов сбора, обработки, накопления и передачи данных (первичной информации) для получения информации нового качества о состоянии объекта, процесса, явления, информационного продукта");
        subjectDescriptions.put("Векторный анализ", "Ве́кторный ана́лиз — раздел математики, распространяющий методы математического анализа на векторы, как правило в двух- или трёхмерном пространстве.");
        subjectDescriptions.put("Квантовая теория", "Ква́нтовая тео́рия по́ля — раздел физики, изучающий поведение квантовых систем с бесконечно большим числом степеней свободы — квантовых полей; является теоретической основой описания микрочастиц, их взаимодействий и превращений.");
        subjectDescriptions.put("ООП", "Объе́ктно-ориенти́рованное программи́рование — методология программирования, основанная на представлении программы в виде совокупности объектов, каждый из которых является экземпляром определённого класса, а классы образуют иерархию наследования.");
        subjectDescriptions.put("Введение в программирование", "Курс \"Введение в программирование\" (и аналогичный \"Основы программирования\") учат правильному инженерному подходу к решению задач");
//        subjectDescriptions.put("Алгоритмы и структуры данных", "Алгоритм — такое хитроумное название для последовательности совершаемых действий. Структуры данных реализованы с помощью алгоритмов, алгоритмы — с помощью структур данных.");
        subjectDescriptions.put("algorithms", "Algorythms are the");
        subjectDescriptions.put("Теория вероятности", "Тео́рия вероя́тностей — раздел математики, изучающий случайные события, случайные величины, их свойства и операции над ними.");
        return subjectDescriptions;
    }
    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertData() {
        // Group Collection part
        MongoCollection<Document> groupCollection = mongoTemplate.getCollection("Group");
        groupCollection.drop();
        List<Document> groupList = new ArrayList<>();
        int startIndex = 1;
        int groupAmount = 10;
        for (int i = startIndex; i < groupAmount; i++) {
            Document document = new Document("group_id", i)
                    .append("number", i)
                    .append("_id", new ObjectId());
            groupList.add(document);
        }
        groupCollection.insertMany(groupList);

        // Subject Collection part
        MongoCollection<Document> subjectCollection = mongoTemplate.getCollection("Subject");
        subjectCollection.drop();
        List<Document> subjectList = new ArrayList<>();
        Map<String, String> subjects = setSubjectDescriptions();
        subjectCollection.createIndex(Indexes.text("description"));
        int subjectAmount = 10;
        Iterator<Map.Entry<String, String>> it = subjects.entrySet().iterator();
        for (int i = startIndex; it.hasNext(); i++) {
            Map.Entry<String, String> pair = it.next();
            Document document = new Document("subject_id", i)
                    .append("name", pair.getKey())
                    .append("description", pair.getValue())
                    .append("_id", new ObjectId());
            subjectList.add(document);
        }
        subjectCollection.insertMany(subjectList);

        // Pairs Collection part
        MongoCollection<Document> pairsCollection = mongoTemplate.getCollection("Pairs");
        pairsCollection.drop();
        List<Document> pairsList = new ArrayList<>();
        int pairsAmount = 9;
        for (int i = startIndex; i < pairsAmount; i++) {
            Document document = new Document("group_id", groupList.get(i).get("_id"))
                    .append("subject_id", subjectList.get(i).get("_id"))
                    .append("date", new Date())
                    .append("_id", new ObjectId());
            pairsList.add(document);
        }
        pairsCollection.insertMany(pairsList);
    }

    public void printSubjectByDesc() {
        MongoCollection<Document> collection = mongoTemplate.getCollection("Subject");
        TextSearchOptions options = new TextSearchOptions().caseSensitive(true);
        Bson filter = Filters.text("Algorythms are the", options);
        Document doc = collection.find(filter).first();
        assert doc != null;
        System.out.println(doc.toJson());

    }
    public void printIndexes() {
        MongoCollection<Document> collection = mongoTemplate.getCollection("Subject");
        for (Document index : collection.listIndexes()) {
            System.out.println(index.toJson());
        }
    }
    public void printTable() {
        FindIterable<Document> groupCollection = mongoTemplate.getCollection("Group").find();
        MongoCursor<Document> cursor = groupCollection.iterator();
        System.out.println("---------Group Collection---------");
        while (cursor.hasNext()) {
            Document document = cursor.next();
            System.out.println("group_id " + document.get("group_id"));
            System.out.println("number " + document.get("number"));
            System.out.println();
        }

        FindIterable<Document> subjectCollection = mongoTemplate.getCollection("Subject").find();
        cursor = subjectCollection.iterator();
        System.out.println("---------Subject Collection---------");
        while (cursor.hasNext()) {
            Document document = cursor.next();
            System.out.println("subject_id " + document.get("subject_id"));
            System.out.println("name " + document.get("name"));
            System.out.println("description " + document.get("description"));
            System.out.println();
        }

        FindIterable<Document> pairsCollection = mongoTemplate.getCollection("Pairs").find();
        cursor = pairsCollection.iterator();
        System.out.println("---------Pairs Collection---------");
        while (cursor.hasNext()) {
            Document document = cursor.next();
            System.out.println("group_id " + document.get("group_id"));
            System.out.println("subject_id " + document.get("subject_id"));
            System.out.println("date " + document.get("date"));
            System.out.println();
        }
    }
}
