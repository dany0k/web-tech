CREATE TABLE IF NOT EXISTS student_group
(
    group_id SERIAL PRIMARY KEY,
    number INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS subject
(
    subject_id SERIAL PRIMARY KEY,
    name CHARACTER VARYING(100) UNIQUE NOT NULL,
    description CHARACTER VARYING(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS pairs
(
    pairs_id SERIAL PRIMARY KEY,
    group_id INTEGER REFERENCES student_group (group_id) ON DELETE CASCADE,
    subject_id INTEGER REFERENCES subject (subject_id) ON DELETE CASCADE,
    timestamp TIMESTAMP NOT NULL
);

INSERT INTO student_group(number) VALUES(1), (2), (3), (4), (5);
INSERT INTO subject(name, description) VALUES('Информационные технологии', 'процессы, использующие совокупность средств и методов сбора, обработки, накопления и передачи данных (первичной информации) для получения информации нового качества о состоянии объекта, процесса, явления, информационного продукта'),
                                             ('Электродинамика', 'Электродина́мика — раздел физики, изучающий электромагнитное поле в наиболее общем случае и его взаимодействие с телами, имеющими электрический заряд.'),
                                             ('Разработка мобильных приложений', 'Разработка приложений для мобильных устройств — это процесс, при котором приложения разрабатываются для небольших портативных устройств, таких, как КПК, смартфоны или сотовые телефоны. '),
                                             ('Математический анализ', 'Математи́ческий ана́лиз — совокупность разделов математики, соответствующих историческому разделу под наименованием «анализ бесконечно малых», объединяет дифференциальное и интегральное исчисления.'),
                                             ('Векторный анализ"', 'Ве́кторный ана́лиз — раздел математики, распространяющий методы математического анализа на векторы, как правило в двух- или трёхмерном пространстве.'),
                                             ('Квантовая теория', 'Ква́нтовая тео́рия по́ля — раздел физики, изучающий поведение квантовых систем с бесконечно большим числом степеней свободы — квантовых полей; является теоретической основой описания микрочастиц, их взаимодействий и превращений.'),
                                             ('ООП', 'Объе́ктно-ориенти́рованное программи́рование — методология программирования, основанная на представлении программы в виде совокупности объектов, каждый из которых является экземпляром определённого класса, а классы образуют иерархию наследования.'),
                                             ('Теория вероятности', 'Алгоритм — такое хитроумное название для последовательности совершаемых действий. Структуры данных реализованы с помощью алгоритмов, алгоритмы — с помощью структур данных.'),
                                             ('Алгоритмы и структуры данных', 'Тео́рия вероя́тностей — раздел математики, изучающий случайные события, случайные величины, их свойства и операции над ними.');
INSERT INTO pairs(group_id, subject_id, timestamp) VALUES (1, 1, '2023-03-09T11:06:14.779Z'),
                                                          (2, 2, '2023-03-09T11:06:15.779Z'),
                                                          (3, 3, '2023-03-09T11:06:16.779Z'),
                                                          (4, 4, '2023-03-09T11:06:17.779Z'),
                                                          (5, 5, '2023-03-09T11:06:18.779Z');
