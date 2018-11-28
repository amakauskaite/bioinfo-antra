# bioinfo-antra
Užduoties aprašymas: https://drive.google.com/file/d/1OMZcVg5yRduGdWTEcAjuUwMlRTDjYxbR/view

## 1. FASTAQ VS FASTA
**FASTAQ formatas.** Įprastai seka koduojama 4 eilutėmis (nors 2 ir 4 punktai gali užimti ir daugiau, dažniausiai laikoma, kad užims po 1 eilutę):

1. Eilutė, prasidedanti '@' ženklu, paskui kurį eina sekos ID bei *neprivalomas* aprašymas
2. Pati seka
3. Eilutė, prasidedanti '+' ženklu, paskui kurį *neprivalomai* eina pirmoje eilutėje rašytas ID ir aprašymas, jei toks buvo
4. [2.] punkte aprašytos sekos narių Phred kokybės svorių seka, kur Phred kokybės svoriai įgauną reikšmes tarp 0 ir 93 ir yra koduojamas ASCII simboliais tarp 33 (!) ir 126 (~) (priklausomai nuo kodavimo būdo)
  
  **Kokia papildoma informacija pateikiam lyginant su FASTA formatu?** Papildomai pateikiamas sekos narių kokybės įvertinimas  

## 2. ASCII ir gimtadienis
**Kurią mėnesio dieną Jūs gimėte?** 9

  **Prie dienos pridėkite 33. Koks ASCII simbolis atitinka šį skaičių?** 42 = '*'  

## 3. ASCII simboliai
**Kodėl pirmi 32 ASCII kodai negali būti naudojami sekos kokybei koduoti?** Kadangi pirmi 32 simboliai yra rezervuoti specialioms reikšmėms pvz. CR (carriage return), NULL ir nėra spausdinami į ekraną

## 4. Failo analizė
### 4.a. Kokybės kodavimo nustatymas
Greičiausiai naudojama "Sanger Phred+33" koduotė, tačiau kadangi faile svorių ASCII reikšmės buvo tarp 35 ir 73, galėjo būti naudojama ir "Illumina 1.8+ Phred+33" koduotė. Koduotė buvo nustatyta išnagrinėjus kas ketvirtos failo eilutės svorių ASCII reikšmes, nustačius mažiausią ir didžiausią reikšmės ir pagal https://en.wikipedia.org/wiki/FASTQ_format aprašytus rėžius nustačius, kokia koduotė galima.
```java
if (max>74)
        {
            //not Sanger
            //not Ilumina 1.8
            if (min<64)
                return "Solexa Solexa+64";
            else if (min<66)
                return "Illumina 1.3+ Phred+64";
            else return "Illumina 1.5+ Phred+64";
        }
        //the only way to distinguish Illumina 1.8 from Sanger is that only Illumina 1.8 can have 'J' as a value
        else if (max==74)
            return "Illumina 1.8+ Phred+33";
        //otherwise - impossible to distinguish
        else return "Sanger Phred+33 ('Illumina 1.8+ Phred+33' is also a possiblility)";
```
### 4.b. C/G nukleotidų pasiskirstymą read’uose
