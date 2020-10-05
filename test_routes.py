import requests


def main():
    r = requests.get('http://localhost:8080/reportingStructure/16a596ae-edd3-4847-99fe-c4518e82c86f')
    print(r)


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

    r = requests.get('http://localhost:8080/compensation/employee/327654gfdjhgff2gdhss354')
    print(r)


if __name__ == "__main__":
    main()
