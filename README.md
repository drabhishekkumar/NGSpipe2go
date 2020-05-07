![IMB-logo](resources/IMB_logo.png)

# NGSpipe2go #

An opinionated framework for building pipelines. It comprises set of NGS data analysis tools and pipelines developed and utilised at the Institute of Molecular Biology gGmbH in Mainz (https://www.imb.de/).

![NGSpipe2go scheme](resources/NGSpipe2go_scheme.png)

## Available Pipelines ## 
- ChIP-Seq
- ChIP-Seq (paired-end)
- DNA-Seq
- [RNA-Seq](https://gitlab.rlp.net/imbforge/NGSpipe2go/-/blob/devel/pipelines/RNAseq/README.md)
- RNA-Seq for variant calling
- smallRNA-Seq
- [single cell RNA-Seq](https://gitlab.rlp.net/imbforge/NGSpipe2go/-/blob/devel/pipelines/scRNAseq/README.md)

## Prerequisites ##
### ChIP-seq pipeline ###
A flowchart for the ChIP-seq pipeline is available for [single-read](https://www.draw.io/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=NGSpipe2go_ChIPseq_pipeline.html#R7V1Zc9u2Fv41mkkf5AF38jGy4zid1E3t9KbpSwbEIrGmSIWkvP36C4CLuEASJZOiZKfpjEUQJLEcnPOdBQcj7Xz%2B%2BDGCi9kfISb%2BSAX4caRdjFRV0VSL%2FeElT2mJbYC0YBp5OKu0Krj1nklWmFdbepjElYpJGPqJt6gWojAICEoqZTCKwodqNRr61a8u4JQ0Cm4R9Jul3zyczLJSxXRWN66IN51ln7bzDrsQ3U2jcBlk3wvCgKR35jB%2FTdbHeAZx%2BFAq0j6MtPMoDJP01%2FzxnPh8WPMRS5%2B7XHO3aHJEgqTNAxf%2FPcUXf%2F%2Fv593z7Nz6QhXyKQHjonHJUz4WBLOhyS7DKJmF0zCA%2FodV6UT0l%2FDXAnb133K%2ByOtP4YKVrJ76HIas4ELh1UiSPGUzD5dJyIpmydzP7pJHL%2FmHv%2FDMyK6%2Bl%2B5cPGbfEhdP%2BUWQRE%2Blh%2Fjl9%2FK91WPiKn8uTmCUZC0x%2BXW4jBD5QiJvThIS3S4g8oJp8SguVWVPTkmypmqcROFdQT9sfifp2PIBXTtnWVHahrToHl3%2Fdftt%2Bfvy4vnfr5%2B%2BXn6P7%2F8daxklpi3YUFFf0RZbriRkDY2e2IMR8WHi3VdbArN1My3qrQiI%2FchoSE5PV%2BB3Oru2E%2F9%2BduNeX91e%2Fni%2BGucL%2Bh76y%2BxTI9X0WYMn2LvnX%2FS9aSBumD%2BXnPQnkVhWxSX7Nc3%2BisfcqF7CGibelZfW6LdEVT50iT8pluh56IeRqKRdiv%2Bkk0bDIKcOhc85hvFMELtSIX1%2BRT3fL730g8n%2FFS%2FN7wieoE2mEcQem%2FdaMQrnHsooaOrDOM6pKWcXQHw2YZMX8oEbO6DotYSQ7kmUkMdSUZMSHnMebaaPZDybv1hcP5Q4oK2nZbMS89OB%2BnLqkdKu8ot8eiGfDqhFtZUKtajAaVCLnpeVqcVUOuA1z9%2BSi6%2Fgn39%2Fv7z5EM0V%2FPXj06ex9mLRdfSCSi5Q9pIfLcWHpkuF1gHkiXSODeW1TzIDGO85gmWXiK9fvpp54aXn581p0kGFqRyAKLShiGJTsyVCgjPfCrXkYoHfGMdivt%2BzCoq%2BeJTIjHN19H4yh17Ax9NbEN9jPJYVTjaLk%2FSr1eJUXO3bkEp3qmXxAgZtyiCfWC%2BpfR7NmEpFfp7lvTtjoi28fyo3IR%2F7vMTF1AbYUV3VUWyIVWQRi9jIwpZDAcbqWLVdrJqmAjSXYNtxEKaOCWwT2ppiExO6KrUVw4WVj8wiQiufmSUJV%2Fbec9JQL6deMlu6Z0y6sQtv7tKQkSj7ef3xljddnYbswvVDlxMQjBkWZz%2FyTsXs9%2Fns0xfWUfarRZfTkVtfMZ9o2ApdyGZjfbFsjusQpXOS2vctY8EEvAS67OnSGmGaP6Fe4AmMqoJ3Lr%2Fz286L5qj77YcQx4LHxQuCBJdj%2Bj%2FvKNf2Q7z0OeGdfv9IHDNB4kHOhmGAi86Nebc9yuSTEDZQaMB7dbgDGnwkaJnw8S7R4JqWrMf3XcBiR63AYrupQ2mWBBUrueGlc%2BGoS4RjbQiYbrDgPxl3XTAtgnc%2BBUQ5xLDzgsLmpUuHa6N0bj2GSmPI8sEpj1he1hpiZN%2F7EnqC2rKPjVWjMmFW9QUhpTGDQvVJKBr9At3WGBLJ5r%2B%2FV1DtNiRbwbErWHsAdUVR20LTAyHTv2MS%2Fen%2Bx43PjFVyw0AVea5j4m74yDmasBJynuaGESbRmBWzixQKZYQvOB5gVG4Ud8rWZX57pGpE5%2F%2BKGguIcfFudZOAaI8R0zGPz5LHil2ljgsNZFuWSVVKFV13DGpoSIGGozoWpZjq7tjG2HVNi1BAVYgBdYBrUwKQoWmmSS1b1SBRECID4cI13UxHqHpzLf5bA%2Bu2G53S0hxHNclmPU3UZSSZV8YPMYqNC7P06hZo1CpIp1RLXU8%2FiRvip0Zho6MJzks%2Bfdk4HKuKzUfzEq%2F8LrYa5rz%2Fnk8CBj5Kr%2FJavZ4XNpu7sQPl73TUiRjOF2LOt767r15df%2Fn7a4edChbLZO3kHLxjHc9Y1rnBJ40LgcW%2BvcgezhoPQlrqURcN54Uy5iB4rGBwZSi%2BGSSpJemdoaoSYOKY0kPQf595ARKOgia5T8AnlH8mZLWoLwxqVNjQJh1D%2FqohXDGbkF8FEgC7D%2BRnlyXgsQPa7MCv%2B5bQZmtD6FHZQZX1htBXBEeFiYUhvoB609EGPOo6pq4BHTkW0g0MEFQdjeqQaqzZxHLssakhS6WuYRFAbcfRqak5mGpUYyq67ViOo%2BqWgXAFAx0Qj67rZzpGtbu%2FEOkeiLQhGYXRknf3IYzuuP2LG7tgAKd8mrihTzCOuDmIt9xGkFmhMvdt3ko%2FRNx0VqZTLnCDkD8REMIY7Nkmubs3amn54M7Y41fDXg56jhzDaEBmg5NgGLMvq6Vq%2F8Ir7fFKbtM9GryyzTq2kIqUOWu%2BF6RSAyxWCCQtH4uVwe%2BZpXuMwJNxtlreC7kRpG6IdfE%2FecGXla9K5r1wWzGHRb1s1qi1V1fTZc9v2nLQNBFwa1foVLhyzu5hFLfx9boGsDHWFE3RVduyMFQU6DLUxMQWNTEZA1NFmkF1U8dAVRTDISagJkXA0kxAAFEszXIdHvLTM4YqHG4lBLW1u%2BmYravWxFQZyt3d19ugk36oogZnFlF472FO4VUfHvSfYi9eQ%2FgbAYhojBjpa%2FZgZbwqYyNpwkanIXiXgiIBh35r2xrZ8G41KaibTQq7CN6HmZcQHvPLn32IRKxzD8LYMtoaFIwDGhRkuuZB%2FYr5B4%2FWsahXplGvvqATx6I0hD%2BPr3zN0OlQAfuSuLpuovdbG5jMYQBaAX8umYD961xw9zbY6OeSMdCEtxCFbM5CTq3CwBzBB9FsEVPCG8uw190oi8DoUPqzajzig934ic7S4kKib5UN6bSslQ0yflaTF5lh47O4utDMNVJCBIVnLwada3NGHnedx2ZrZoPzFWbqF6pzbQSIPJL3VLhUf9G2eksmoHeutolH30cRfCpVWHABFq%2BXaHoezFRYCZwyYWyvrzs1QkpbsK%2F0k5KV4mykK%2BK74cMvkhrn%2BzGPjKR0HfRPIlt8Yb9IJOM6znGSCDgEiWzG0G%2BERDqe%2BcbUGkpV09VVp%2FqKDK2nT63m%2FMWCy%2BqWhFxriT%2BG1%2F8syHz8142TOOijObAatstOpU63lbXmLoPtK5MqzZtRwxGh0UJnVqo6s%2FoGlObWtPVSpXkQeGxm26i74kpy49DJxAGdZlaGtiSapm8Y0K7DAEzikR8xaW3auSFZPMRiwUezTyNOKQhGNFPZ3ZKjl8a3T0tOv9uH1Hyv0ECWG%2FnYZqabkumfT9j4ls8YKPlV38VsAEX4ELf7%2FdbgPNx3Wxr4zHVbtY7xga2HSMw9jAVjqs3RquQmGxlttCZ7gkigIeIyUq6QMXfWLGPC%2Fmejec4ZlMGaec6uldU1%2B59Xj5LzMGCvhp6YbMKI%2BIHEyaiZ8KEDstBs5ay6TSl3J2zzCWn6znTRkgjMBhG0922KfXyZhxPs4cz%2Fc5mkgdg8sRMnmfcN%2FsZu%2FkSbGNtw3vuUl7G7YdENT%2FA91p2o0u42zs6XhxKVCTbPWHIJ557Pae2K%2BPeEv3V0CNenpdtVDGWo7ei8t0AkzToyOgcNUo9IvPST%2BDiJ%2FR0jMtY34dUHCwLvVuR%2B2OiIC49SEhVREFlTfC9OJPGcx7bcelhaumO3W1p2b0vLPvql5YfTI11XrGXjXGyg0PcZhiO4ECEEotkoj7l5C8SsGmcto2S6kBRy1frlIaudpk589cp25ivarmw7PQVRtEzAsD6H3bEg5YhwheZIOd2%2Bwa5cJ007dnYzx5uiXFWAHR1qCGNqW8B0LN1wLYyRDm0KHMcamw6mkBpAU20bONBUCCulruYYQLeBaju2qeqm6%2FQe5cqT4HIDSTFhl%2FHMC55%2BZKmKfqTlbP394DUzS4p8ENIhbNx%2FyUai%2FefpTHSDNeRsRvwFieKzm00TxiZJMTFWLc0CioIAMlyg6xqEmuFgHZljkyoa0CHSdE3VCYaKblu6ZkHgUNXUEdYoZTUddJwTtmU0VjMnr7jrFA4Wn8wpj%2FH9ggFxNhXx4S0nkqooC633WA%2FTIYa3PMoli1hLoukCkSQcjKFlnIjOyQKw41GeXClhZBjPGLeOU2GUR0W37%2FCrtwqYTkvrVydZleTRa92CvcwqeTAfYpFiMvvwKr9kr4EFPQWyNVxrVu7mqkWebQss2O5la%2B1fmcB5F2GzqzQaoz4dLmnULPvYHkGz%2BqGCZvsNktWUYV0tcp1SfzGbOfJY%2FgpnOU011Giphg4ey7%2BYwYBBEGH6bMuZGBNjcIi1wENxCu%2FhXOCHeSrcgesFYpM%2BY10zhmYQG3wvTkTtg3iIS53anXUZr4N1SfDQIVmXPP7tZFhXjQV1Fwynmy05g251jYteyirIY0KytC5tuMSHtHrq6OevJsFUKD1sfrhKw9UgeD8VCh6czkma75VPYv%2BoJu3K7ryhzK1PhzfUI0gM2xqUN8jDq09hk0Z3iR260p6sluwkP5rjeNgJ0yzOuYlBHLvVkqcgxksSkWQvjOZsacXCv%2BV60wee8QgkDGvcHWIvIWs7ytq%2BOxOxTpKJ1AGGmdtRjomJaKfARDqFE3ZbRePo4ARH5z9gEBTHVrXlAWxhQKZPiFMEUvvovRdzY8lz%2BqID6RjV5u%2FOBuyTZAMNLAGaISPDm0jUU9Ez3rCJpO1hhcObSFzUmjl9Ob9hb5uEScLUHYJ4ONl5SCj1kEcyu%2FIBWJO7h8W2vPngdNhRHZXo5rCqjZwdnUxeg7fLjoy2gUODsyNvwQYitaW05UoLX2QWTZPL5w8fhhetWrszSzLKp9SeLksyjGNUlAZlSad2MKbeepepfSAtqzHLkytFOZ8%2Be%2Fr8SsM3l3j%2B%2BRGP30DWrwEmuXtVWjy6897ifB9MAX227C02wYvqG1ls%2Fp57kVvLtzlEsdpetKV7NhD0%2FcPtQBVN3B1iv479p7o6rMa%2F0bx9NAHVzX0juXH6GOOpXW%2F6rWJBz%2FaMZIa1ODOsvcEtUYbTMu254exM7e2c5q9eeexSiNuthfhQQG1js%2FdiX72nRb8hYpckP4UPfCRBWDlYbYNsHp6vpfsPJn9%2B%2B%2FrpA58DtigehctwWulGfcNCfhfwnKF8hwIT%2B8t0AA4dTS7a74U8N3bJV8IXB7rjntP0yK7W21UHyTSexbzzU09462MxE3zxbUmyvlei7yPL213FTqYusQU4TlOa9Hf2r93M1NEYuH6TdBfM7u0m6d6wJfE0j%2BoqpEBp85hYXZvh7ls7XSodkmqSD%2FbnHVsxmCdEGBW7neqb8PIdQ3eBl0S%2Fra6pF4jcBUXCh3SPABTkJttCkHrMS%2FuNmJ67iMvHTb3Z85qOtmGj4Q6S6kkuOlbVuGTlLvuyYLQlTN7WXi4X5bu3rCH1rP0s4qOd9KzSFi%2Fkwzj20Ki8y6vrSGdFab0J4qh0saLdg9iS8uOEN%2B%2FNhw8YcsXkGG1J4pyF0SqB1btnb7GonuDzWoxFtVN5JBGRB86e4wxIue2soDxVZGXj8hFR7mpj5dtM%2FyTLLHngfDnmkEK4C2OndTw5l6VSdT9ZnhvBtzvAgZziDptm2TIrrsrt9TOTRN%2BuTZGa4yZL%2B9HWw5lNDtfhUmua8MwwjnaHw4dgtEqUwTvUu%2Bszzy7Cu7CzB9Qp86PT9YBa2rAe0CvwO51d24l%2FP7txr69uL388X43XO0AbtMXFi1R81u0oukxKfiZTsa%2BvoN30dQ0p6a6VklmO39IkSfPxcuFYK2qkBV6bBlhGFVVB0YUANap8JD8AsUQXukx%2BdmHclRJB8wBGcSb8aJX2r4Wld%2FuS62LoGpnum0tKZuTV%2Bxq6l3jgzDp0LpkV89FcFYpxldkU0%2F3zgRvzP6V0R6vJGRwi74mLD3x0uZUD2Yy4FKXpQVB0GXXtflpqO%2Bo6pNNlI3m%2FXZ%2BLdFhO0OWSWXwvU9%2FBhuX41pwrv3wHJ9WwAZ0aHYiYugNDhl9kEqaLwxeknGzInPRearS%2BDGsmwKOMCHoDhr06cbbHP2ZP1Lk%2BrXsR5PMpYcOJygGyq%2FgfMZ%2FLmJMUyIitSIH5apVLq2qdVdqymN60y6Z34SLd9yfsTiSN68JsxESKDlnwgYg1eM1TVoWxitU0CKjSKesrePhkEm4dOHhYnp5s1M7IfSh%2F9Ta78hGEBk88pshRnownTe8HsuTWpxQenH%2BhfXpy3smzIpx1Fbi6Njm5AW1AdWS6iGBs65pNXFXDtqYQ1wSY2mNkYkhtA5u6pUDFRpqlWMh1oEuRZRm2xRi9AS0XVz7SR3Jymc1%2Fa3czxXRNtXySG7nHpaQwbDbyF9ADExNxS3Jgk4kwhaZrqrbtqgTZyKaa45qOg6iuk7FpElsxHQtZiBJTVQhSiUF1mzquSxl5uABR5GB1OHLY0NsSNTRrrSWGNVO%2FIQZ8FWAuxYz1F5RCHtO8%2BiBv3SiPiixHqIswyoj8XHppXGaRqr3O4faKUt%2BcJrMkTppesiOI3qvFvRhK0x8mz70Odo%2Fea%2BMQk46iKlE5%2BjK5boITb9jkKo%2FxGDTQ8jCY9FAhHs3DoaTQdD843Dq1nC2n6n5jPiytFsOR6VXrYj7q9XXDrFF3PzEf2UFswp%2F3mR8d1z7P3eJJDH8sDiUUp86luXMLM1tWmFvb1FFvASBzL%2BYmfBiQcMmvs14J73IRB6JKI0HW09bJBYIYSlXwFWdKHFO2qUFVfnC2E4NlFwWv28J0tT0NAZ2wQlko%2B1a6PmD4W%2FUgaEt9UaaOdmQ2cAKhzshMqZKZuq%2FBqTc62x5J1%2BcWiY3NbIWtl5H%2FNOFpJXiHtjHpFYWkV3lu2Iuxs6O1rz1X1y2jdpK6AWzJ0aH5YTAVd561%2BxizSyYmk%2FJyZOMw%2ByPEHER8%2BD8%3D) and [paired-end](https://www.draw.io/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=NGSpipe2go_ChIPseq_pe_pipeline.html#R7V1pk5s4E%2F41rsp%2BsItDXB%2FnyEySSmazM9k3m%2F2SEkjY7GAggOfIr38lITCHjPGF8cxstmqMECCpW92PulutkXoxf7qOYTT7EiLsjxQJPY3Uy5GiyKpikD%2B05DkrMTUpK5jGHuKVlgV33m%2FMC%2FNqCw%2FhpFIxDUM%2F9aJqoRMGAXbSShmM4%2FCxWs0N%2FepXIzjFjYI7B%2FrN0u8eSme8VNat5Y0P2JvO%2BKfNvMM2dO6ncbgI%2BPeCMMDZnTnMX8P7mMwgCh9LRer7kXoRh2Ga%2FZo%2FXWCfDms%2BYtlzVyvuFk2OcZB2eeCD9Mmd3Zip%2FzC7tW8%2B3F39%2FP1hnBPgAfoLPhYjRffJC8%2BR90BH1%2FemAbuh%2F1rQpp7HbBiKS%2FJryv%2Byx%2By4XkKaxN6Vl7LBSJ%2FzsZ%2Blc5%2F8ksk9H9rYPy%2BG9CL0w5hVUq%2FYf6RKksbhfUEkMojnbhiknKNknbYbJjOM%2BBvZe4or1%2FP90kvf6%2FRf8dL8DqOhej6NIfLI2NaKnXDuOeRSolV8mCT8d0FeiX02hakX0oEbW1LR6zKxOP0ecJzip1IRJ941Duc4jZ9JFX7X1Dmt%2BBwbW%2FwVjyWONXmdWYlZgZTPFD5LpsW7l%2BxCfnCOEXPPg3Pz1933xafF5e9%2Fv338dvUjefh3LL%2Bxz0HYZw%2FcophyhVsKUVviFiBZTW7R84q7cMvv7%2BnlN%2Bmffz9d3b6P5zL6dv38caw2aIcRkcL8MozTWTgNA%2Bi%2FX5aWCEDHZVnncxhGnCr%2F4TR95hSEizQkRSWewE9e%2Bg99fKLxqx%2BlO5dP%2FM3s4jm%2FCEh3Sw%2FRyx%2Fle8vH2FX%2BXJO5VhIyCRexg1umFh%2BsFMZTnLbVA1lFOpStfBFjn4ikh6rC2zuNNfmlExkH6IwiDnLp0PlLZzMtvPL8vDlNPqgIlR6YQj0WU7Q1W6AkqPCtcEuuFuiNccLofUYqyCB6EuiMC2V0dj6HXkDH04uw7xEZSwrP29VJ9tVqcaautm0If0kSwaBeBinBvLT2WmdGoC3%2B9TPCk7zhE6K1wofn8tvzYc1LZM1FBgK67ZqGhSTZNHSoQE2DGsaSZpljRceGZaqaq6kY6CqAUDWQZpi2qiqmIQNkAtNQFafykVmM3cpnZmlKcfcZpbpyNfXS2cKeEMVFLry57YaE%2B8jPm%2Bs72nRlGpIL2w9tyhswSTEZ8qu8Uwn5fTH7%2BDXrK7no1vFsCFvr5sSEAgKL6LAeWOyREXbj6zGbul4KbfJ0ibPJ%2Bgq7XuAxZKlI72x654%2BNWX3Q%2FfZDiBImmZKIrPSobCKrLNpRuqYK0cKnPHX6%2FcNJQsS%2FB6nwhGT1mHduTLvtuUSrMBUBiQSmE2qLDu%2BBB5%2Bws0jpeJd4cEVLVqPyfYBZS6mAWbOJZVVDgGVlZQ9YVqjSgECl1YaAIPqI%2FiSCMyLYn3Y%2BgzE5MDDzgsKyAITD1apTO49hc7GoCNaKeVlnYMC%2F9zX0GLfxj40VrUIwo%2FqC0HUTAmDqRCgavcOKVDsm%2Fsx%2F%2F6hg0XX4s4I%2Bl2C0h0WGrHQFlD3hyb8THP9p%2F0dNfERU0uV8FS%2BuEuJ2%2BEQlmhdMM5lmhzHC8ZgUk4sM5XDGZxJPIlyuFXfKNjx6myztMaD%2FihoRRKh4t7IfBJiNeTJJnyrWkDrk0xzTMHRXcV0ZAIsCO0eGmqVYhusiF9hjEyHb1g3sSq4CkeRakm26WHI0VdV11zAVFWLZcfAxIB%2F5taKb2QhVbx4K0eU4qsk2q3miriPxvDJ%2BDuFY0iSHMUXphVKjVsE6pVrKav5J7RA9NwobHU1RXvLxa%2BtwLCs2H81LvPK7yGyY0%2F57Pg4I%2BCi9yuv0elrYbG5rB8rf2VMnEjiPGM3XvvtQvbr5%2Bve3PXYqiBbpSuL03rE9U4x37uhEo0og2rYX%2FGHeeCl0Sz3aR8NpoUg4MBnLBFwZireDJKWkvTmqKgEmiik9B%2Fpn3HafUhR0nlvyfezSz4SkluszM5jLLF%2Fne4b8VfO1rDchvyIJAOw2kJ9cloDHBmizcO29oc0uaLOz%2BXJQ1kt5tfnyBcFRZmIhiC9wvemoBY%2Falg5UCTiW4QANSQ5ULNUF0FVJs6ntcayrjqG4tmZgyTUtC7i6aiFXdVWyRDctw7IUYGgOqmCgHvHoqn5mY1S7%2B4ZIt0CkDc3IjJa0u49hfE%2FtX9TYBQM4pWSihj4mOJLmIN5RGwG3QnGna95KP3So6azMp1ThBiF9IsCYCNhJm97dGrV0fHBj7PHWsN1Bz8AxjCqJbHACDKMfymqpmG94pTteyW26g8Er66xjkVClzEnzvSDTGlK0RCBZ%2BZjNDHpPL90jDJ6O%2BWw5Y3ojyNwQq6J28oKvS1%2BVyHthdxIOUb1s1qi1VVezaU9vmmLQdM7g1qbQqXDlTB5gnHRw49q2JpkIqbIqA8U0DARlGdoENRG15eoIjyVdcVTNBTpAkiLLmoV1ydVdRzJUXcISlg3VsC1ZPjiGKhxuJQS1trvZmK2q1sRUHOW2MISIFiI%2BOQxX1OBMFIcPHqIcXvXhQf858ZIVjN8KQFhj2EjfkAcr41UZG0ETWp2G0rsMFDE49EfX1oiGd61JQWk3KWyieB9nXorvCJSlzz7GMDqMMja0rgYFrUeDgmit2atfMf%2FgYB2LoEJGUH3BXhyL1qfYvL%2B%2Fcu79b%2BdjeHktY%2FnzK3AsVmLU9hrK2Nnuow8ESBUw5Yoowr8umBTugmF%2BLYigS2kLHbJaj0PKVcwQHMNH1mwW%2B0EbSzDS%2FYhHSuxRS5NqNDKD3PjlTLLiQvOuleEZnVbKcJHcqcl1boD4zK4uVX2FNGch1%2FzF0t5XXVoe1ZxHPgPQkFCFOXnHZVcXQS%2BOkz0VaXK4WFbQUSqAvS%2Bv2KNncQyfSxUiqmiS1ZoH1ALqVdkoM8b6%2BppRY6SsBdtqKSFbyVYrX2HfDh9fBEuJdXRHjso3pw2Mo4AuHZ5DlPZdGMPgkP1Zf%2F5bzKO8b3wHTg8iS7WGwWC1HWOqtl8GE07C5oLlhW0A2Ss07qwEBweNiZxIPazQqP6u8PgWc99PFFEH1CGBcMnhl7UzwpvjYdATHj5ssLRiGkfFv%2BKx5QC4ZOigJBvfUZpJJSvyuwh6MaZsgwNqw6rJFmqoLo07t1NXlxh0XOv%2BoLmHEBM9NRItS275wKijFRs82R5f5oTK5AKXxqRZ2jn5nwzmBZUsGmnmBbmWl9fkf1o9Ti%2FCgLwaeozWmHDxI07SUXNP6h64QjXlSTUmW2kui4QGMBVszBYNHvh1jaAvX%2F199b8ff53dW9faZSQVe893UBVl9T5lc6kn5bFKCdTk85ZaQe%2BqFSQxzXva1qc35nB3QzzbdMLN8dIWnqc%2FF2kWNUhzPdApf9bQUOTmL6dNMx3P1ZSpImodKrrhMcVFuhNX2t3FMr%2B737sscPJN8Vdw7vmU3z9g%2FwHTt476sNMbwKypL7ObnDqY11w1BsbnUoPVY5ws%2FDQZJrO%2FI0xG%2BsZcUFKE4f2S3ft15V16rovjwmXHm%2BJ7SSoIPhradDvA1NLzabRuapkHm1rm4KeWH04HOq9Iy8a52nBC3ycQnAHlTIVg6MxGuYP4FTAzAAXA7UNTCBFtu%2FW1d0C7m1F2j4AWSB0BraUfE9DmzRyMNGoC2hjTdeNABdK2AVR05Z91bHI7R22RU4qELABVByHXNCTdMoBmGwg5AJquZFnGGOrkBnBdXbFdWzUtxXWQTKaholpIdYBsyq5jyebhd0PS9HXUEFUQ7CqZecHzz2VOi5%2FZLS%2BY%2FqSVudFKPA7ZKDbu7xKfvj2pJqwnpCGTGfYjHCeT2zaaETrJOkKKoRqSLDuSo9kSACqEqmYh4OhjgxBGxZaqmS7AUNdsU7UUCCxb0SQTIseAjmnp0nBptmZAlsQTV9yUikeLfKPMR6R%2FIYaosIrpCJdTlDBEMhFxXOsuuOP06EuIPJcqGDafWNsZfkgpdHIWScp6J4rtS0Z53o6UsGIyI0I7yXRSHnDXvcMvfg2vW52D7fYAzcS%2BYWNnbDZw5%2BfB4rfA6cZvncP5PsK3ltuuR4d0WmXRW%2BRjWwRvgb6Ctw4brKUqTZNEn84qoex4S1y5ibQQOC%2FaonX63%2BUrbs3b1qgdidxTJMyuKoFIcR4SsAi8X4vu0QuZFXvEfDYUcS781BsXsQw9BPcuYxrqfdhcW5TtLKejLeqhDaquCmx%2BR9cXeVqtlytLDoc1jY6CxexLfXQPiILzC7oqY0cNdJQpDpEaKUt5E8ZzMsMSZsC3vekjzT8gpTF07vvYMUDa7vC2by5LjJOUJXXkqeVnPQxJkryBkk1kh9kVlBhDkx3UFf0TBkFxbERX%2BUEmFYy9hOUDzsxRD15Cl7G%2Fsxf1g0dqzd9chJgnKULqcEQXnLFwdBEig5cuQw4HRqyuAmVwhq%2BPAanJzcEdZcmUZdvx2IN0dOizSwN%2FKQq3b4NY1iTans0Fi3WSgkXLBUke2yAdN4RbLFiOahY7acGidY2HGJ5g8SIyEDiY8ixlXQRL5LOsXFli1vzhfoDJsrUbiw6tHFt9QqKjtqwBR979IT4J6qjbn0%2FOot55k5g5NGkxh06idBcUWUCuA32%2Fv%2F1hrImbA4uXsTdMU5rB9UffG5ab9gYThtcMCs4Nc0OMwrO96feK9ZAHBHPDQMINA68w3l2Tm9x%2BsABh21ig6%2FDmnwjPx3%2FdWqnlXOunk%2FZjCPY8s%2FN2%2B57UXkfxJTobaDAJGm8x2wJDzwORrnEQVo54aNHNx5drWcjq%2BZ%2Ffv318zwwVCD8xk8S00o16jGt%2BV6JZkWhQK1H7i2wA%2Bg4%2BZO33Qpqlr2TrpZPDuadeo%2BzwgM57kY6S85CHSNL8y7T1CaMEnXxr0j1ulXJwYBkEa9ZeILD2Wr2eQmY2d9E3Bu6w6QILYfd60wW2bGQ5zUMDCi1Q2m%2FAZlc73H1tee6zIanu4CZ%2F3pEZg3BmLOfG8%2Fq%2BjTzA%2FD7w0viP5bXrBWxjarGbN4s%2BhYzdRMGpmcevFJ5O1rlRUk58%2F2ozxw%2B2YaPjpbQ%2FkF60jKq3wpAVUVSWKRDz5ua5dTvmVzxquP92FsbRRiutrc4h334xJucJcE9sNVa0%2ByjWpPxos%2FY9nfARQbo0GaI1ieWSHS3zk7z77UVRNZv4cZYkZKmUBd4SdfhAlx5sKZWZuire6or1eThbz7Kz4eTJrTxhYzyZ%2Fh52O5Ut2nnS5sNaxnjBzhTxHjbpUMu9PJh%2BwIZxGg9f2fo4IFG2DFp5nelexNHy%2FWbIGNAuTGM7C7ixrQl8L5k0rK45jg%2BVGq6z65dtdb%2FlO%2Bm7eoB5%2F6lSz6yNTJ2T6X2PwsdgtNx43otrON%2BtT7uwsYfYKk%2FO0%2FUQGyIrZ48e4g%2FSJ3d2Y6b%2Bw%2BzWvvlwd%2FXz94fxagdxg7eorBXqkrqdCYhUxmc8ZQGPBe9mr2uoDHulyuAJSktEEiYTpZqiVtTIaboyh6mIK6pCcx%2FaRKuu8hW9wRdApEr2YfwWMkHzqBx2eudomfOqgyV8%2FZTbx9CZNT%2B0ICRLZAQHhxq6XTyUeh1Hlsyu%2BWguC9m4ihYZZFVBF3F2Qv%2BU0ocsiXN0vLglSOz5kMk6c8mSJbK%2BARF%2F7cH6JuSvPt1SrQz%2Ber1SwmE5QacUt4lfZd6Vlgn52txPrYPxar0rg23YEd0%2Be1AydRePCMGINMw%2BcscLJdkxUzJ7mVH%2FKqxZxAYZM%2FUK7Fx15pQlszMC0g%2FEn6vzGhcW848pGVCnHES8NKYzii4Slm6Es1uRVe7FLjDrQFbTu5LxYGvMpsH9MtsTxqxPOIt%2BQ2TMWBIHUYgGi8h4yURTq0QzmuYiRUgya3eSCUOsX%2Fx25y29%2BsLB6mpNfjvhvrDwnXtkMefSdC0pk94Szxp7SkHU%2BRe65%2F2lnZwUQb8dzrjXoCm5wNFtByNkAtXEtqIiU5WxrUvINceOjqBrakgHhgxl01EN2XBsC9quYxiaaRBBr0HDRpWP9HXG%2Fdru8sXpimo5kRsZfQd4uv0O%2FEDURNKRHQgxHeRC3dYV07QV7JiO6aqWrVuW4wKAx7qOTVm3DMdwXKwrMnYUrLnAdC3bdgl72JLjOhZSjscOLb0tcUOz1kpmWEH6lkj5ZRi%2BEDXWX1AKDM2yVUt560Z57Gg5jj87qRr%2FWvDgmSL%2FcV3CbRXL36q0231lA4hxrMWCdN5JJkvqxkqwi1tMOIqKYNFxKLNrG5x4PWbXzt5wfj4L83R8pifKdM%2FwFD0zhJaws4rYYTRkQo5Kgee8MLdCKKODucbnXkJNmzDA4YJe814xv1vhIVeEPnIhv5xm2idNrgoD48jZWYSBNkddBkmTjRZC5OIrjj2WV3%2FN4kjdcnG0afCNWLwJQqDX8nWPx4lXz%2Fc0FK3GWLud9ixksyMn8tgbm8lVNlP6CvLqzGfrY4wOGVrf2sxOeGMR%2B8%2FnNCEB7dA6Ib3kkOwqz4p4ObY2tIB0l%2BrA0GoH5GoSEBkgBTs8ydp19zEWJtk6shgfbKKctozy62MjgXCy9jCPhM0eUEzspmfEVTKk9UC4vrLJd8yAJ58K5VbBKbB%2Blxm5qmvN4%2FNBXwl8u4Ggpto7MTboC%2B3sRHTV2pHG26FqvepcBgYo88va%2BqoFavy1EQrvbGC4nV8uou5mhS8wvh%2FRk%2B7m4QO1J6JF5DM3Jhr1cZRFltg1npPPtkbWr2aYk7Ma1APrQY5ChmQ1eIX55psn7m4n21YbArrItqNYDAy1tnGfJ8ZfJdvq9YGh7CLburHkHkDW0Q5VPra%2B3S2dqGocgynrClTTzI0Ubp6WaUumpGopDNNydaINZl9CRFXv%2B%2F8D) sequencing.
#### Programs required ####
- FastQC
- Bowtie
- Samtools
- Bedtools
- Picard
- UCSC utilities
- MACS2
- ChIPSeeker
- encodeChIPqc (provided by another project from imbforge)

#### Files required ####
- targets.txt (sample names)
- raw reads (.fastq.gz) or mapped data (.bam)

### DNA-seq pipeline ###
A flowchart for the DNA-seq pipeline is available [here](https://www.draw.io/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=NGSpipe2go_DNAseq_pipeline.html#R7R1rd5u48tf4nO4H%2B%2FB%2BfIyTOmm37bZJ93a7X3oEEjYbDBRwEvfXX0lImIew8Ru33d17Y4SMpZnRvGcYqNfzl9sExLP3EUTBQJHgy0C9GSiKrCom%2FkNGlvmIpUv5wDTxIZu0GnjwfyA2yKctfIjSysQsioLMj6uDbhSGyM0qYyBJoufqNC8Kqr8agylqDDy4IGiOfvFhNmOjsmGvbtwhfzpjP23xDTvAfZwm0SJkvxdGIcrvzAF%2FDNtjOgMwei4Nqa8H6nUSRVn%2Baf5yjQICVg6x%2FHuTlrvFkhMUZl2%2BcCe99WYfrCx4mt07H%2B4eJt9%2B3A05Ap5AsGCwGChGgB84hv4TgW7gT0N6w%2Fi%2BIEsdJxQMxSX%2BNGV%2F6decpD6Cl0SfxUcpMLIlh%2F0smwf4k4zvBcBBwbgA6XUURAmdpE7oP3hKmiXRY4EkDMSxF4UZoyjZIOsG6QxB9kT6nOLK84Og9NDXBvm3eCi%2FQ3GojqcJgD6GbW3Yjea%2Biy8lMiUAaco%2BF%2BiV6M9mIPMjArihLRW7LiOL4e8JJRl6KQ0x5N2iaI6yZImnvPAzxWiOnbGhreTXzyWKtdjYrESsmsQGATsl0%2BLZK3LBHxjFiKnn9e3726vM%2Fjh%2FVm5vwbf0%2Bs%2Fl26HZQCaC%2BFyxyyjJZtE0CkHwejVawgiBy2rOuyiKGZr%2BQ1m2ZCgFiyzCQyUiQS9%2B9g%2F5%2BkhnV19Ld25e2JPpxZIjp0E1rQhJo0Xist08uR8%2BPXxZvF3c%2FPj385vPk6%2Fp079D1WAMCiRTlK2ZqLGzRWCyFsEJCjC1PFV50T7IEi5H%2Fn3Wj3LWD3C0FUuuHO1CLpaOtibZzaOt29L%2B1PLjS3bzWfrn37eT%2B9fJXIafb5dvhuqlHG0M9WRZ%2BhK5%2FFq%2Bt%2FoavToKS%2BjIEVTtXBxBiGNd%2FtmRjEJ4RdRDfOmS80tOMxmc%2BAFfTpMOKkzlBESh9kpMqK1CgjDfCrVwsUBuDFOK7ys8QdbiF4HMuFYGV%2BM58EMCTz9GgY95LB4crxcn%2Ba9Wh3NxtetC2EPSGIT1MUAQ5me1x8IQpOj7iC96hCVW9LQsP5mDlI%2FIwLQVV9IRNDUNKo5tea4DdGwnGY6CVH0IkayrQJdlFymmh1RXh8CChqZCBWlIkx3dkIHtWZUfmSXIq%2FzMLMuIgXRFMK5Mpn42WzgjLLTwhT93vAhTHv744faBLF2ZRvjCCSKH0AVIM4TBPeGbSvHnmw9XeJ9EhG%2FccA621nkceUCAUBHc62rDAdG8H9UO6cH0M%2BDgb5foFpu6yPNDnyr5ivTKIXf%2B2JqQe73vIAIwpXwnjbHRTTgPNnjJRol5G8FFQKjm8veH0hQzdx8Q1giwIc83NyTb9j0sM6gAAJi%2FkiOzw4YPQIMvyF1kBN4lGmxZSbvOfQhVlVud3NPT1FRVU6CpysoBNFWxmSUQWDUQYH09Jh8xa4yxZk82nyspXOxbfKBw8mhCcK2VmJ1hKDdAxoFThhgf6yz22e99jHxKbezHhopeQZhZfUDkeSlWT%2BpIKBa9O14Kv9dZtEv%2B%2BWtF09ykXVZ0y5WqeQITQu6sLvZKW5Tb1cU2Lu9EL4Tl%2BeE0Z3pOlECUDPEwvsgVHXYyKEuUMBnpxZ2yv5XcxpY90ZeQVsyIAYTFs5XDKIBU6GHFKvT86Tq1z7GxBidprm26mg4lFyi26mnAU%2FGykWlbQ6iZtmTJsgltA1myactQdS1XNRXd8ywVuAr%2Bn2kZ51H72raZg6h29zAqHlesmmTSTgN1oYnmFXC5mGzxAlxKBKUHSo1ZBamUZint9JI5EVw2BhuqXgbrI36hLxOdkWz3OUoeifpBdA0QginBCdGzKJcolKqVGvlAWDRTAphHi68yiFyiuZSJ0sP%2FF0bkGyFCmJuOSjjw64sT6qrNPTRHOn6RDDZh1AFqvxdWHxTRHxnPz1CL%2BkfUEh%2BTyBVz7mZEkI65qzdAHvlWhGd5AfWTeNQ1Mj6w1lj3bzZDF4ok0IGMYymNivVbOemunHCVujfKyd8pSv5y%2FiOhYGzHkUhCVfeIhSJljpfvh7nUkOKVupGPD%2BnJIPeM0j1M4NmQnZYrKjfC3ApsC4nwgY8rV4HIeHQ6MYe4PjZrzNppq%2FmxJzctsYY0prpVu57UXXcqrOvRE0jSDr4zx9ElC0JVVmVNsUwTAlkGjql4WJR5BkRD18Nqk4EkRZMc14YK1qQ000A60DHlGZosWRYC1Hw6shJV%2BEBWKtTG3eYga5vWWaliyu8a0mnRwRoUdRz6qSk%2BcRI9%2BRA1nC0gWKZ%2B2nJE1qoq48JN8wF%2FsQLGCmwES1jr3ZFe5eoTVZz%2B6LoaEXiVjTJIKTFHJrRK8mgbEf088zP0gJVe8t3nBMTHEduW0U1sy9znsAVLx5clrr6NKBeZoCd1APEf7K0HSKugUTuCB8h%2Bm1iPjxP3Mfg8HoKbWxnJ74ay%2FrMrWZVQ4UEjyp3dQUZPVK5CoZlg8fjpmnLhLtrO9wVmdBlZoYvt%2BiQiVBURFpyAZ7ps6qQni8Xa1OOAubQPKLvxNOJCxze%2Bu6N8uBDIG3l4jqdWHi7iOzW%2BzlwV7%2BjVjWq0cHOa%2BcIeLB3cPtN5cgnn9JrW4FCycRgDrQujF7KTJlv%2FybIVDspAtI4MROsdAxl%2FufoWo84M5B4xP1ocE2dejVU4z2D7Q62d6FAfNzSHjaezHmIxbPWGtoaNp%2BEDsZ6kks38KgZ%2BgghiUUj08NrJJ2Z5CezMKq%2BySQLWuvdr7kNIGUMNQ6uRewYXddCSK0hze6nLLT%2B1MdG2KOT0Mf4Pw%2FKanHsdL%2FMaX8ura%2FwfmZ5k11GIHw18imqEJc8zSrNBM73xAEShWvKoGgBUmqxdqMSr2tZU0ZEEDIHC3tUYpRFyZpJKO%2Fhp%2Flpk8YJwIFIjQEjmqsF%2F8M3v7jrecz7HTM7JiIZUbMOnWgzeTsLWLb1iGhjPZri9%2BvwnBXfiA2oXIAJ5mp%2B%2BPmOlZszu71Qu0zdP552AuR8Q0rxDwRMiTz2JaWtqVuVUqNyM3OiSNo91LMyeHQupcTISlC6CLO3n2XhyvdJ5eMZGwYroyQgm14AKFGe5OhR3IA6ibBmja3KX%2Bn%2Furv8ojs7foe%2F5CN6ikE6i9%2F%2B%2B%2FX1qCleCJHHpsuncWMcK5ahW789NEE17emjwyob8yLgRPgJuRs9ILk4QcMkh4lKnXyR%2BDHIWlFQdLS4prKjihR%2F9d5kd0ljllVIbjVX7VMZqx9TD9oqqvmiyCSIGR0%2B5z%2BY4ozimyKR6vrfR%2FRyuiye60NI9w5IkCXqaBYFn2yqUXAXYhirZqjz0JMPTDdkFtmcYuinJlgld0zBsDVgG0qGJVN2RSPXlkeOJpOSZeCQLnE3SmR8uv%2BVp9t%2FyYWyifiMT8d21YGBKkWDKtplb9bDbzvga0e3gtYxmKMDaVDq6X4c4jCSEJMOxZcU0NaAqliqZuisjC0BT1vWhhRTXgIaKdN2SZV3SPQQMVYbQNmTD9ExD9RTds9S%2BIm4DPCoYFM%2FdIQnvJAHgj3ihWA4U%2FIdwqYSAtFxBQfWO0UAQq30fQd8jbJwSLJ24UundRZrRR4nCx2mhumcY0ekMs8Y05%2Fw8plsCRSOk2xfV5kTau8ET9TfHcw%2Bg7wh9%2Br%2FLTLdRkwSV5%2BLA64m0pM4u%2Ffv5zYIx2S4u%2FfcgeaTsdB7RoiO4iAN8SHLT5FQRwWSOfzbdOniQI%2BnigweqYQos%2B7PHAOWzMoyLTinQuxpZ%2FUsp%2BF%2BuA73GdlZnHpJXDEDn4cNHEohRpClz4lFPR%2BhGCQQhBhi9hzJ3dFSWUiQIMnWOuOC3Zi26NLhE1lJPLlAV4%2BysRZ5owdd3t5%2FG3pfPt768%2BGINLz4jXD2lKtI5vcA6l8dGiGT7N5L3Q7IQqvq5cOyDyaen509v3qgTO%2Fhx%2F%2BVN%2BEM5AI7%2FW8xjPn9KOeKZsa7sWu1RQ8mRD7tq74l3%2BtWrJAHL0gSWYLF6ci2%2FVeNSgskX3ZDLNLR5vqXVaC5fQcdc2O55TSBF98jFItlJWHe4zilO%2FFtEeyHPwX8%2B0cRJn4ZuaFOV8dX7QREAPYUuk5Q3s72hdKlZVtWkeF1tJnOfUpdxzAW8jT78E6P58NO9ndnurTH86ROvDynmrM7s7Vxibu2ydwo%2BHb387R55CKOCGFgSSZ%2BYo65mWz%2BCUuMvV5SvQvRCvU7Tyh7qIRHopGE8Ihko9LmPYfQcDirZJ7kPe5vdnrgwiznZSTk5YeeFVNlUqrZTXVTPypyqri9dF3B0%2B6Q9baxmlmwDcMetaSq4y69b07Q2A%2BESG54UbLcaFaYHbH1%2BwK%2FWuSMHSTXLFv95hQ8NRl2eIZXHMwUBdh6ofAz9LPljde35IS17LbIo8zonQIlOVAaVBzJLYU6sisdpuZvHL9sOo7cLG5yvT8eRpKNtVs1lwxbUhlkCVn%2B03sT6xfQd39W82alv7e4WkMwrdS%2FMBCrWfZYEvDdhl%2Fw78AxBBjbI1zOZOrTodbBKmn%2F1w4%2FjatuD85glIZjTWj4iDJ%2BI%2BUG7rOZJyeXCsKoHbUM%2BzwnXn4J5HCB5dC%2BPKIxH0x%2F9XqeywzoPI8DOlPpdb23RbGMqzoSSjmXyqfYZWVm3MgZSYltJoOsRK3PAvMTIqGLNqheI0kx4W1EgTAL%2BRUYRlVXziGQW0BtvwvzdRveIgm1OKIzeYF73is%2F7dyHQKuaidDtAlr3%2F%2BRFG%2FeT9X2ZQDvulM5CcMPB31Pgdj1h0fGPNyeN3ttjAaI3f1eabjHUeO35HM7Dv19RTlDTAgh8w5BBNJnezUh0G87RHmPuIeYL0KQJ2PIec7GDreJ1d5giXFK%2BrencN47ytTcSvYWuV%2FQ0Ru18v%2BXdoStTmFfW2NLF3WmUX67xQQpKwS0L59UtsqNGsobU5g4gqqqz6ICKs%2Bj41pdncTBNJsEM4%2FYVEcM76bz%2B3ZSdRTRHsZXyu7zrXAYiz7nSTeQ5lmWtpAurkNQIHp872KuvCTHyTYXC6Zdm4siApPhcpLaFnxFYU5Py0HIYruxyJutUNiUdjMU0b8yZPN6e6B0slgtwwEsUkaAjiZ0ZZNa4oG7aowYEQaQewbITJPNrehs3PmcwjBFZXU%2Bd3p%2BpCxRv72L7CJsUcb5Rwb4mVs15Sug7%2Fhe41yWSToyLbpUNfah1Ykqe5huMiCC1NtZCjqNBSZeQYEvSsoaJ4qmYrnm5KrgFUyUGqqUPT0xTL8ZBlWq4DHQTlyo%2BcqC%2F1xt3mIGub1tc6472Qj6VC2hH3mqS70AOGYyiW5SjItVzLU23HsG3X0zQ0lFQNeraJL23TcTXdNoHi6CqCQDdsCxoKdFwZElP0TLhfs9kS6puztsX8mnSwVa7ZuhhDMVDKe8jL5iW%2BugFPjSgnq%2BU9Y9H3BYsOFWXidW62VyPvdpnT6hjpQQi%2FFuzQlKYx0RLtUI%2FiAxFCUREYGDW952Apb%2BtUh184403sWG%2Fi4eLraU5VTiOkM6urimrtqZLu5I03lZo33ljvja%2FP19m5PbY3nnUrGxNR%2BI70V%2BtaTONG8ZKCP32kImSaS5hBKd2PDXIf2BFd83M%2FJfmMIETRglyzXdF3rRUuekXopG%2BnrYvz0etyjebU8%2Froha3ZztyqZCu2hy8%2BosTP32lSY4VylRXuXFq4k3XeNc%2BMhyxPn2gmxL3xk%2BD%2BNMXEnVG%2FTjweDvM7BqWrOrOh7yXWuqnAwnTGNh14kQTLcQLcRwLNTUx6RYz5VcYKUG%2BG9paI7s7VNatudjRbLMuCshrVUvY%2FxsLuMWf1pPa429S6JlKbk0a0c7Fqobmyf%2Blr76yVk1X%2F70UH%2FSj%2B11glQt%2BK%2F2leYTmpcIvXm1ANvVbfLwHyizxbMY5SnznCjmislAr%2Fi32sSyNqJ6eLs1DqWUQa76bVpw5GPSqLkToyuqp4k7fmc5VuaR15XHsDm408jmO9J92MDpDzeqGOuGMimb%2BI4%2Byx4UIqsP535B0Vf992lhzXeWVpqQnBIs2rapqvtTiF1GALceku1suNNuxdnNyo977TLL2Pve9%2B0dcOdPbE95kj3HV%2F12Y7R2i8B%2BfEDOHuevv%2BURfq665zBFn0Cp2zZ6Q3X6pMYxKD1dtg2vxSW8H7AAA1rVpXc4FmLorLattDsxvoLrBDCGtNMNnYpehXawSyFhi%2FbJOL3i5scL7uGwfgZLZRFQ1GsyJFmC5%2BiDd1it9G1V6XtDmbz6iXpJSOLgfsapCCWHRuwZxgInRS8qf09pCVnKnNaV5La0lLmLe6xQprlNSDdK%2B6RBQXjygCkXiA4hExISkCQuqgQOyU3LWelH%2Fd7C5hLx1lfVoDCpzo%2BexG3wEDI83gzu72Y%2Bd3rPPeDueOaddiH6ou1Uhqv5i2MB63f%2BpEGWWsaujy6E5IAId7DVCPI3KqbZWp7NgRORKeiqKsPB0L1tn7iETK1Nf%2FBw%3D%3D).

#### Programs required ####
- FastQC
- BWA
- Samtools
- Bedtools
- Picard
- dupRadar (provided by another project from imbforge)
- GATK

#### Files required ####
- raw reads (.fastq.gz) or mapped data (.bam)

GATK requires chromosomes in bam files to be karyotypically ordered. Best you use an ordered genome fasta file as reference for the pipeline (assigned in *essential.vars.groovy*, see below).

## NGSpipe2go preparations ##

### Put NGSpipe2go into the project dir ###
NGS projects should be run in a consistant and reproducible way, hence NGSpipe2go asks you to copy all tools into the project folder, which will ensure that you always use the same program versions at a later time point. This can be done either from a local NGSpipe2go copy, a version from the GitHub releases (https://github.com/imbforge/NGSpipe2go/releases) or using the most recent development version from the GitHub repository

    git clone https://github.com/imbforge/NGSpipe2go.git <project_dir>/NGSpipe2go

### Choose one of the pipelines ###

Select a pipeline to run and make symlinks in the main project dir, e.g. for RNA-seq project

    ln -s NGSpipe2go/pipelines/RNAseq/* .
    ln -s NGSpipe2go/modules/RNAseq/essential.vars.groovy .
    ln -s NGSpipe2go/modules/RNAseq/tool.locations.groovy .

or for single-read (SR) ChIP-seq project

    ln -s NGSpipe2go/pipelines/ChIPseq/* .
    ln -s NGSpipe2go/modules/ChIPseq/essential.vars.groovy .
    ln -s NGSpipe2go/modules/ChIPseq/tool.locations.groovy .
    
or for paired-end (PE) ChIP-seq project

    ln -s NGSpipe2go/pipelines/ChIPseq_pe/* .
    ln -s NGSpipe2go/modules/ChIPseq/essential.vars.groovy .
    ln -s NGSpipe2go/modules/ChIPseq/tool.locations.groovy .

### Customise NGSpipe2go to your needs ###

Adjust the project-specific information in the following files:

- *essential.vars.groovy* specifies the main project variables like project dir and reference genome
- *xxx.pipeline.groovy* describes the pipeline steps and the location of the respective modules
- *targets.txt* and *contrasts.txt* contain the sample names and the differential group comparisons
- *tool.location.groovy* and *bpipe.config* specify the paths and resource allocation for the tools

Additional software parameters can be customised in the *xxx.vars.groovy* files accompanying each bpipe module.

## Run a pipeline ##

Copy the input FastQ files into the <project_dir>/rawdata folder.

Using GNU Screen (for persistence) load the bpipe module customised for the Slurm job manager, e.g.

    screen
    module load bpipe/0.9.9.3.slurm

Start running the pipeline of choice, e.g.

    bpipe run rnaseq.pipeline.groovy rawdata/*.fastq.gz

or

    bpipe run chipseq.pipeline.groovy rawdata/*.fastq.gz    

or

    bpipe run chipseq_pe.pipeline.groovy rawdata/*.fastq.gz

## Compile a project report ##

The final result of the provided pipelines will be saved in the ./reports folder.
The Rmd file can be edited or customised using a text editor and then converted into HTML report using knitr
    
    R usage:
    rmarkdown::render("DEreport.Rmd")
    or
    rmarkdown::render("ChIPreport.Rmd")
