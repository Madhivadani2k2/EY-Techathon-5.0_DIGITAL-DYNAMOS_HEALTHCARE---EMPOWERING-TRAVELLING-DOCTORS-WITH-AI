# using flask_restful 
from flask import Flask, jsonify, request 
from flask_restful import Resource, Api 
import joblib

# creating the flask app 
app = Flask(__name__) 
# creating an API object 
api = Api(app) 
class Model(Resource): 

	def get(self, str): 
         model=joblib.load(r"C:\Users\Vasantha Raj\Desktop\react\Django\Django\medical\myModel.pkl")
         result=model.predict(str)
         return jsonify({'result': result}) 


api.add_resource(Model, '/model/<string:str>') 


if __name__ == '__main__': 

	app.run(debug = True) 
