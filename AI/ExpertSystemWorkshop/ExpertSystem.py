from pyknow import *

class Drools(KnowledgeEngine):
    
    @DefFacts
    def needed_data(self):
    yield Fact(='ph')
    yield Fact(best_body='cd')
    yield Fact(best_sweetness='ground_texture')

    def ask_ph():
        self.declare(Fact(ph=input("What's is the ground Ph?")))

    def ask_cd():
        self.declare(Fact(cd=input("What's is the ground electricity condutivity?")))
    
    def ask_ph():
        self.declare(Fact(ground_texture=input("What's is the ground texture?")))

