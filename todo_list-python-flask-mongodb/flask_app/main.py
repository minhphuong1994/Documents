from bson import ObjectId
from flask import Flask, render_template, request, redirect, url_for, \
    jsonify  # must have url_for to add js script files
from pymongo import MongoClient


app = Flask(__name__, template_folder="./template")

client = MongoClient("mongodb://127.0.0.1:27017")
db = client.data #my mongodb name is data
todos = db.todos #my mongodb table/collection name is todos

t = "Todo list Web App"
h = "Your list are: "

@app.route("/")
def load_api():
    list = todos.find()
    # print(list)
    return render_template("index.html",todo=list, t=t,h=h)

@app.route("/create", methods=['POST'])
def create_api():
    todo = request.values.get("task1")
    todos.insert_one({"task":todo})
    return redirect("/")

@app.route("/update", methods=['PUT'])
def update_api():
    item = request.json
    print(item)
    todos.update({"_id":ObjectId(item['_id'])},{"task":item['task']})
    return jsonify(item)

@app.route("/delete")
def delete_api():
    key = request.values.get("_id")
    todos.remove({"_id":ObjectId(key)})
    return redirect("/")

if __name__ == "__main__":
    app.run(debug=True)