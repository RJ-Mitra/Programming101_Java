#include<bits/stdc++.h>
using namespace std;



string getMostCount(string str, vector<string> banList){
	unordered_map<string,int> wordCount;
	vector<string> words;
	string word="";
	for(auto i:str){
		if(i == ' ' || ispunct(i)){
			if(word!=""){
				words.push_back(word);
				word="";
			}
		}else{
			word+=tolower(i);
		}
	}
	for(string i:words){
		if(wordCount.find(i) == wordCount.end()){
			wordCount.insert(make_pair(i,1));
		}else{
			++wordCount[i];
		}
	}
	int maxCount=0;
	string maxKey;
	for(auto it=wordCount.cbegin();it!=wordCount.cend();++it){
		if(it->second > maxCount && (std::find(banList.begin(), banList.end(),it->first)==banList.end())){
				maxCount = it->second;
				maxKey = it->first;
			
		}
	}
	return maxKey;

}


int main(){
	string str = "Hi there, this is me! Who this, man?";
	string commonWord = getMostCount(str, {"this"});
	cout<<commonWord;
}
