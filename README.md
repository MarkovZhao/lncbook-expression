# LncExpDB
### Introduction

LncExpDB is a comprehensive database for lncRNA expression. It covers expression profiles of lncRNA genes across various biological [contexts](https://bigd.big.ac.cn/LncExpDB/help#structure), predicts potential functional lncRNAs and their interacting partners, and thus provides essential guidance on experimental design.

LncExpDB currently houses expression profiles of 101,293 high-quality human lncRNA genes derived from 1,977 samples of 337 biological [conditions](https://bigd.big.ac.cn/LncExpDB/help#structure) across nine biological [contexts](https://bigd.big.ac.cn/LncExpDB/help#structure). Consequently, LncExpDB estimates lncRNA genes’ [expression reliability and capacities](https://bigd.big.ac.cn/LncExpDB/capacity), identifies [25,191](https://bigd.big.ac.cn/LncExpDB/featured) featured genes, and further obtains [28,443,865](https://bigd.big.ac.cn/LncExpDB/interactions) lncRNA-mRNA interactions.

### Data Structure

![img](https://bigd.big.ac.cn/LncExpDB/images/data_structure.png)

### Data Collection

|        |                          |                     |                                                              |                  |               |          |                                                              |
| ------ | ------------------------ | ------------------- | ------------------------------------------------------------ | ---------------- | ------------- | -------- | :----------------------------------------------------------: |
| Number | Biological Context       | Project ID          | Dataset                                                      | Source           | Sample Number | PMID     |                         Description                          |
| 1      | Normal Tissue/Cell Line  | E-MTAB-2836         | The Human Protein Atlas                                      | EBI ArrayExpress | 121           | 28940711 |        HPA Expression profiles of 32 normal tissues.         |
| 2      | Normal Tissue/Cell Line  | SRP013565           | ENCODE Primary Cell Lines                                    | NCBI SRA         | 111           | 29126249 |           Expression profiles of 55 primary cells.           |
| 3      | Organ Development        | E-MTAB-6814         | Development of Brain                                         | EBI ArrayExpress | 55            | 31243368 |    Human RNA-seq time-series of the development of brain.    |
| 4      | Organ Development        | E-MTAB-6814         | Development of Cerebellum                                    | EBI ArrayExpress | 59            | 31243368 | Human RNA-seq time-series of the development of cerebellum.  |
| 5      | Organ Development        | E-MTAB-6814         | Development of Heart                                         | EBI ArrayExpress | 50            | 31243368 |    Human RNA-seq time-series of the development of heart.    |
| 6      | Organ Development        | E-MTAB-6814         | Development of Kidney                                        | EBI ArrayExpress | 40            | 31243368 |   Human RNA-seq time-series of the development of kidney.    |
| 7      | Organ Development        | E-MTAB-6814         | Development of Liver                                         | EBI ArrayExpress | 50            | 31243368 |    Human RNA-seq time-series of the development of liver.    |
| 8      | Organ Development        | E-MTAB-6814         | Development of Ovary                                         | EBI ArrayExpress | 18            | 31243368 |    Human RNA-seq time-series of the development of ovary.    |
| 9      | Organ Development        | E-MTAB-6814         | Development of Testis                                        | EBI ArrayExpress | 41            | 31243368 |   Human RNA-seq time-series of the development of testis.    |
| 10     | Preimplantation Embryo   | GSE71318            | Oocyte to Lateblastocyst (9 Stages)                          | NCBI GEO         | 35            | 27315811 | Expression profiles of oocyte, zygote, 2-cell, 4-cell, 8-cell, morula, earlyblastocyst, middleblastocyst, lateblastocyst. |
| 11     | Preimplantation Embryo   | GSE36552            | Oocyte to Lateblastocyst (7 Stages)                          | NCBI GEO         | 90            | 23934149 | Expression profiles of oocyte, zygote, 2-cell, 4-cell, 8-cell, morulae, lateblastocyst. |
| 12     | Cell Differentiation     | GSE122380           | Cell Differentiation                                         | NCBI GEO         | 297           | 31249060 | 16 time points during the differentiation of induced pluripotent stem cells to cardiomyocytes. |
| 13     | Subcellular Localization | GSE116008           | Subcellular Localization                                     | NCBI GEO         | 36            | 31230715 | Nine subcellular RNA localization(nucleus, nucleolus, nuclear lamina, nuclear pore, cytosol, ER membrane cytosol facing, ER lumen, Outer mitochondrial membrane, and mitochondrial matrix). |
| 14     | Exosome                  | GSE104926           | Blood Exosomes from Early-Stage Esophageal Squamous Cell Carcinoma Patients vs. Normal Control | NCBI GEO         | 12            | 32043367 | Blood exosomes from early-stage esophageal squamous cell carcinoma patients vs normal control |
| 15     | Exosome                  | GSE100063,GSE100206 | Blood Exosomes from Colorectal Cancer Patients vs. Normal Control | NCBI GEO         | 44            | 30053265 |   Blood exosomes from colorectal cancer and normal control   |
| 16     | Exosome                  | GSE99985,GSE100206  | Blood Exosomes from Coronary Heart Disease Patients vs. Normal Control | NCBI GEO         | 38            | 30053265 | Blood exosomes from coronary heart disease and normal control |
| 17     | Exosome                  | GSE100207,GSE100206 | Blood Exosomes from Hepatocellular Carcinoma Patients vs. Normal Control | NCBI GEO         | 53            | 30053265 | Blood exosomes from hepatocellular carcinoma and normal control |
| 18     | Exosome                  | GSE100232,GSE100206 | Blood Exosomes from Pancreatic Adenocarcinoma Patients vs. Normal Control | NCBI GEO         | 46            | 30053265 | Blood exosomes from pancreatic adenocarcinoma patients and normal control |
| 19     | Cancer Cell Line         | PRJNA523380         | Cancer Cell Line                                             | NCBI SRA         | 658           | 31068700 |         Expression profiles of 51 cancer cell line.          |
| 20     | Virus Infection          | GSE125686           | HIV Infection vs. Normal Control                             | NCBI GEO         | 22            | 30185599 | Transcriptomic profiling of peripheral blood NK cells of chronic HIV patients. |
| 21     | Virus Infection          | GSE125686           | HBV Infection vs. Normal Control                             | NCBI GEO         | 48            | 30185599 | Transcriptomic profiling of peripheral blood NK cells of chronic HBV patients. |
| 22     | Virus Infection          | GSE125686           | HCV Infection vs. Normal Control                             | NCBI GEO         | 24            | 30185599 | Transcriptomic profiling of peripheral blood NK cells of chronic HCV patients. |
| 23     | Virus Infection          | GSE147507           | COVID Patients vs. Normal Control                            | NCBI GEO         | 4             | 32416070 |      Transcriptional response to SARS-CoV-2 infection.       |
| 24     | Circadian Rhythm         | GSE113883           | Circadian Rhythm                                             | NCBI GEO         | 153           | 30201705 | Whole blood was collected every 2 h over a 28-h period (15 points). |

