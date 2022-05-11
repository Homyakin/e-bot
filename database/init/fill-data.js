db.additive.insert(
    [
        {
            "names": ["е100", "е-100", "e100", "e-100", "куркумин", "турмерик"],
            "type": "SAFE",
            "description": "Оранжевый краситель.",
            "positives": "Может оказывать противовоспалительную и противоопухолевую активность.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/kurkumin-e100/"
                }
            ]
        },
        {
            "names": ["е101", "е-101", "e101", "e-101", "рибофлавин", "витамин b2", "b2"],
            "type": "SAFE",
            "description": "Жёлтый краситель.",
            "positives": "Нормализуется работа щитовидной железы, репродуктивной функции, регулируются процессы образования клеток крови и антител.",
            "recommendations": "Противопоказаниями являются: гиперчувствительность, нефролитиаз.\n" +
                "Рекомендованная суточная доза - 0,5 мг на килограмм массы тела",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/riboflavin-e101/"
                },
                {
                    "name": "rlsnet.ru",
                    "link": "https://www.rlsnet.ru/active-substance/riboflavin-508"
                }
            ]
        },
        {
            "names": ["е102", "е-102", "e102", "e-102", "татразин"],
            "type": "UNSAFE",
            "description": "Жёлтый краситель.",
            "negatives": "Острую опасность добавка представляет для астматиков и людей с аллергией." +
                " У детей может вызывать гиперактивность и снижение способности к концентрации." +
                " Среди других негативных последствий: синдром Мелькерссона-Розенталя, отёк Квинке, опухоли и прочее.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/tartrazin-e102/"
                },
                {
                    "name": "calorizator.ru",
                    "link": "https://calorizator.ru/addon/e1xx/e102"
                }
            ]
        },
        {
            "names": ["е103", "е-103", "e103", "e-103", "алканин", "алканет"],
            "type": "UNSAFE",
            "description": "Тёмно-красный краситель.",
            "negatives": "При больших дозировках способствует возникновению онкологических заболеваний." +
                " При попадании на кожу может вызывать раздражение, покраснение, зуд.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/alkanin-alkanet-e103/"
                },
                {
                    "name": "calorizator.ru",
                    "link": "https://calorizator.ru/addon/e1xx/e103"
                }
            ]
        },
        {
            "names": ["е140", "е-140", "e140", "e-140", "хлорофилл", "хлофиллин", "хлорофиллы", "хлорофиллины"],
            "type": "SAFE",
            "description": "Зелёный краситель.",
            "positives": "Освобождает организм от токсинов, повышает защитные функции и препятствует развитию раковых клеток.",
            "negatives": "В синтезированной добавке возможно наличие примесей, которые могут вызывать аллергические реакции, головную боль или расстройство желудка.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/hlorofill-e140/"
                },
                {
                    "name": "vkusologia.ru",
                    "link": "https://vkusologia.ru/dobavki/krasiteli/e140.html"
                }
            ]
        },
        {
            "names": ["е200", "е-200", "e200", "e-200", "сорбиновая кислота"],
            "type": "SAFE",
            "description": "Консервант.",
            "positives": "Способствует повышению иммунитета.",
            "negatives": "Возможна индивидуальная непереносимость. Длительное потребление продуктов с данной добавкой увеличивает " +
                "риски появления аллергических реакций на руках и голове.",
            "recommendations": "Суточная норма - 12,5 мг на килограмм массы тела.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/sorbinovaya-kislota-e200/"
                },
                {
                    "name": "calorizator.ru",
                    "link": "https://calorizator.ru/addon/e2xx/e200"
                }
            ]
        },
        {
            "names": ["е202", "е-202", "e202", "e-202", "сорбат калия"],
            "type": "SAFE",
            "description": "Консервант.",
            "negatives": "Иногда может вызывать аллергические реакции, которые выражаются в появлении раздражения на слизистых тканях и кожных покровах.",
            "recommendations": "Количество добавки не должно превышать 0,2% от массы продукта.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/sorbat-kaliya-e202/"
                },
                {
                    "name": "vitaminic.ru",
                    "link": "https://vitaminic.ru/pischevye-dobavki/sorbat-kaliya-e202"
                }
            ]
        },
        {
            "names": ["е211", "е-211", "e211", "e-211", "бензоат натрия"],
            "type": "UNSAFE",
            "description": "Консервант.",
            "negatives": "От длительного употребления может развиваться цирроз печени, болезнь Паркинсона, почечная недостаточность," +
                " нейродегенеративные заболевания. Ускоряет процесс старения. Не выводится из организма и может спровоцировать рак.",
            "recommendations": "Количество добавки не должно превышать 0,2% от массы продукта.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/benzoat-natriya-e211/"
                },
                {
                    "name": "vitaminic.ru",
                    "link": "https://calorizator.ru/addon/e2xx/e211"
                }
            ]
        },
        {
            "names": ["е220", "е-220", "e220", "e-220", "диоксид серы", "сернистый газ", "сернистый ангидрид", "сернистая кислота"],
            "type": "CAUTION",
            "description": "Консервант.",
            "negatives": "Большая дозировка может привести к тошноте, диарее, отёку лёгких, мигрени и другим последствиям." +
                "Разрушает витамины B1 и B12 в организме.",
            "recommendations": "Перед употреблением обработанных сульфидами фруктов, овощей или сухофруктов их необходимо" +
                " тщательно промыть под проточной водой. После положить в емкость с водой (девяносто пять-сто градусов по Цельсию)" +
                " и продержать там от пяти до десяти минут.\n" +
                "Суточная норма - 100 мг на килограмм продукта.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/dioksid-sery-e220/"
                },
                {
                    "name": "calorizator.ru",
                    "link": "https://calorizator.ru/addon/e2xx/e220"
                }
            ]
        },
        {
            "names": ["е250", "е-250", "e250", "e-250", "нитрит натрия"],
            "type": "CAUTION",
            "description": "Консервант.",
            "positives": "Является сильным антибиотиком.",
            "negatives": "Способна повысить риск к развитию онкологических заболеваний. Летальная доза - 2-6 грамм.",
            "recommendations": "Продукты, содержащие витамины групп E и C способны замедлить процесс нитрозирования.\n" +
                "Норма - не более 50 мг на 1кг продукта. Но лучше выбирать продукты с консервантом E202.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/nitrit-natriya-e250/"
                },
                {
                    "name": "calorizator.ru",
                    "link": "https://calorizator.ru/addon/e2xx/e220"
                }
            ]
        },
        {
            "names": ["е300", "е-300", "e300", "e-300", "аскорбиновая кислота"],
            "type": "SAFE",
            "description": "Антиоксидант.",
            "positives": "помогает превращать холестерин в желчные кислоты, триптофан и катехоламины в серотонин, способствует образованию коллагена, синтезирует кортикостероиды.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/askorbinovaya-kislota-e300/"
                },
            ]
        },
        {
            "names": ["е322", "е-322", "e322", "e-322", "лецитин", "соевый лецитин"],
            "type": "SAFE",
            "description": "Эмульгатор.",
            "positives": "Борется с большим показателем холестерина, является средством для профилактики возникновения и развития атеросклероза," +
                " способствует равномерному усвоению жиров. Улучшает умственную активность, память, поможет побороть депрессию и избавиться от стресса.",
            "negatives": "Могут возникнуть аллергические реакции при индивидуальной непереносимости.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/lecitin-e322/"
                },
                {
                    "name": "calorizator.ru",
                    "link": "https://calorizator.ru/addon/e3xx/e322"
                }
            ]
        },
        {
            "names": ["е330", "е-330", "e330", "e-330", "лимонная кислота"],
            "type": "SAFE",
            "description": "Лимонная кислота.",
            "positives": "Замедляет процессы старения, оказывает положительное влияние на состояние кожных покровов.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/limonnaya-kislota-e330/"
                },
                {
                    "name": "calorizator.ru",
                    "link": "https://calorizator.ru/addon/e3xx/e330"
                }
            ]
        },
        {
            "names": ["е412", "е-412", "e412", "e-412", "гуаровая камедь", "гуаровая смола", "камедь гуарового дерева"],
            "type": "SAFE",
            "description": "Загуститель.",
            "positives": "Способствует снижению аппетита и уровня “плохого” холестерина, улучшению обмена веществ и усвоения кальция, выведению токсических веществ.",
            "negatives": "При передозировке может вызвать тошноту, повышенное газообразование в кишечнике, боли и спазмы желудочно-кишечного тракта.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/guarovaya-kamed-e412/"
                },
                {
                    "name": "calorizator.ru",
                    "link": "https://calorizator.ru/addon/e4xx/e412"
                }
            ]
        },
        {
            "names": ["е621", "е-621", "e621", "e-621", "глутамат натрия"],
            "type": "CAUTION",
            "description": "Усилитель вкуса.",
            "negatives": "Cистематическое употребление пищи c данной добавкой приводит к головной боли, одышке, повышенному потоотделению," +
                " покраснению кожных покровов, боли в груди, ухудшению зрения. Существует опасность переедания.",
            "recommendations": "Норма для взрослого: 10 г/кг веса. Для детей старше трёх лет: 3г/1кг веса." +
                " Для детей младше трёх лет не рекомендуется к употреблению.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/dobavki/glutamat-natriya-e621/"
                },
                {
                    "name": "calorizator.ru",
                    "link": "https://calorizator.ru/addon/e6xx/e621"
                }
            ]
        },
        {
            "names": ["е951", "е-951", "e951", "e-951", "аспартам"],
            "type": "CAUTION",
            "description": "Подсластитель.",
            "negatives": "При длительном употреблении возможны аллергические реакции, головные боли, депрессия, мигрень и бессонница.",
            "recommendations": "Норма употребления - 40 мг/кг веса.",
            "sources": [
                {
                    "name": "foodandhealth.ru",
                    "link": "https://foodandhealth.ru/?s=%D0%95951"
                },
                {
                    "name": "calorizator.ru",
                    "link": "https://calorizator.ru/addon/e9xx/e951"
                }
            ]
        }
    ]
)