db.additive.insertOne(
    {
        "names": ["е140", "е-140", "e140", "e-140", "хлорофилл", "хлофиллин", "хлорофиллы", "хлорофиллины"],
        "type": "SAFE",
        "description": "Зелёный краситель.",
        "positives": "Освобождает организм от токсинов, повышает защитные функции и препятствует развитию раковых клеток.",
        "negatives": "В синтезированной добавке возможно наличие примесей, которые могут вызывать аллергические реакции, головную боль или расстройство желудка",
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
    }
)

db.additive.insertOne(
    {
        "names": ["е202", "е-202", "e202", "e-202", "сорбат калия"],
        "type": "SAFE",
        "description": "Консервант.",
        "negatives": "Иногда может вызывать аллергические реакции, которые выражаются в появлении раздражения на слизистых тканях и кожных покровах.",
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
    }
)