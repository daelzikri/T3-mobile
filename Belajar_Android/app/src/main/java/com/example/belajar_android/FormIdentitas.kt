package com.example.belajar_android
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
class FormIdentitas : AppCompatActivity() {
    private lateinit var etNama: EditText
    private lateinit var rgJenisKelamin: RadioGroup
    private lateinit var rbLakiLaki: RadioButton
    private lateinit var rbPerempuan: RadioButton
    private lateinit var cbMembaca: CheckBox
    private lateinit var cbCoding: CheckBox
    private lateinit var cbOlahraga: CheckBox
    private lateinit var btnTampilkan: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_identitas)
        etNama         = findViewById(R.id.etNama)
        rgJenisKelamin = findViewById(R.id.rgJenisKelamin)
        rbLakiLaki     = findViewById(R.id.rbLakiLaki)
        rbPerempuan    = findViewById(R.id.rbPerempuan)
        cbMembaca      = findViewById(R.id.cbMembaca)
        cbCoding       = findViewById(R.id.cbCoding)
        cbOlahraga     = findViewById(R.id.cbOlahraga)
        btnTampilkan   = findViewById(R.id.btnTampilkan)
        tvHasil        = findViewById(R.id.tvHasil)

        btnTampilkan.setOnClickListener {
            val nama = etNama.text.toString().trim()

            if (nama.isEmpty()) {
                etNama.error = "Nama tidak boleh kosong"
                Toast.makeText(this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (rgJenisKelamin.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Jenis kelamin harus dipilih!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val jenisKelamin = when (rgJenisKelamin.checkedRadioButtonId) {
                R.id.rbLakiLaki  -> "Laki-laki"
                R.id.rbPerempuan -> "Perempuan"
                else             -> "-"
            }

            val hobiList = mutableListOf<String>()
            if (cbMembaca.isChecked)  hobiList.add("Membaca")
            if (cbCoding.isChecked)   hobiList.add("Coding")
            if (cbOlahraga.isChecked) hobiList.add("Olahraga")

            val hobi = if (hobiList.isEmpty()) "Tidak ada" else hobiList.joinToString(", ")

            val hasil = """
                Nama    : $nama
                Kelamin : $jenisKelamin
                Hobi    : $hobi
            """.trimIndent()

            tvHasil.text = hasil
        }
    }
}