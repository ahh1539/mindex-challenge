import requests


def main():
    data = {
        "employeeId": '327654gfdjhgfgdsgf2354',
        "firstName": 'test',
        "lastName": 'user',
        "position": 'manager',
        "department": 'finance',
        "directReports": []
    }

    r = requests.post('http://localhost:8080/employee', json=data)
    print(r.content)

    data = {
        "employee": {
            "employeeId": '327654gfdjhgff2gdhss354',
            "firstName": 'test',
            "lastName": 'user',
            "position": 'manager',
            "department": 'finance',
            "directReports": []
        },
        "salary": 100000,
        "effectiveDate": "2016-10-02"
    }

    r = requests.post('http://localhost:8080/compensation', json=data)
    print(r.content)


if __name__ == "__main__":
    main()
